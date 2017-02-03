package software.postcode.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import software.postcode.api.Application;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.ValidateRecord;
import software.postcode.api.service.AddressRecordService;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * The RESTControllerTest class is a test class
 * that tests RESTController.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RESTControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Mock
    private AddressRecordService mockAddressRecordService;

    @InjectMocks
    private RESTController restController;

    private String test1Address = "PL1 1AB,PLYMOUTH,,,St. Andrews Cross,,5,,,,,Post Office,18911184,L, ,1A";
    private String test1PostcodeResponse = "PL1 1AB";
    private String test1PostcodeRequest = test1PostcodeResponse.replaceAll("\\s+","");
    private String test1UPDRNRequest = "18911184";
    private String test1UPDRNResponse = test1UPDRNRequest;

    private String test2Address = "PL1 1DA,PLYMOUTH,,,Old Town Street,,3,,,,,Warrens Bakery,18911235,S,Y,1Q";
    private String test2PostcodeResponse = "PL1 1DA";
    private String test2PostcodeRequest = test2PostcodeResponse.replaceAll("\\s+","");
    private String test2BuildingNumberRequest = "3";
    private String test2BuildingNumberResponse = test2BuildingNumberRequest;

    private String test3PostcodeResponse = "FY0 0LX";
    private String test3PostcodeRequest = test3PostcodeResponse.replaceAll("\\s+","");
    private String test3BuildingNumberRequest = "00";
    private String test3UPDRNRequest = "0000000";

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {

        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);

        // Set up the response for test1
        String[] test1AddressArray = test1Address.split(Pattern.quote(","));
        AddressRecord test1AddressRecord = new AddressRecord().populateAddressRecord(test1AddressArray);
        List<AddressRecord> test1AddressList = new ArrayList<>();
        test1AddressList.add(test1AddressRecord);

        // Set up the response for validate test
        ValidateRecord test1ValidateRecord = new ValidateRecord();
        test1ValidateRecord.setPostcode(test1PostcodeRequest);
        test1ValidateRecord.setValid(true);
        List<ValidateRecord> test1ValidateList = new ArrayList<>();
        test1ValidateList.add(test1ValidateRecord);

        when(mockAddressRecordService.getAddressRecords(test1PostcodeRequest)).thenReturn(test1AddressList);
        when(mockAddressRecordService.getAddressRecordsByUDPRN(test1UPDRNRequest)).thenReturn(test1AddressList);
        when(mockAddressRecordService.validateAddressRecords(test1PostcodeRequest)).thenReturn(test1ValidateList);

        // Set up the response for test2
        String[] test2AddressArray = test2Address.split(Pattern.quote(","));
        AddressRecord test2AddressRecord = new AddressRecord().populateAddressRecord(test2AddressArray);
        List<AddressRecord> test2AddressList = new ArrayList<>();
        test2AddressList.add(test2AddressRecord);

        when(mockAddressRecordService.getAddressRecords(test2PostcodeRequest,test2BuildingNumberRequest)).thenReturn(test2AddressList);

        // Set up the response for false validate test
        ValidateRecord test3ValidateRecord = new ValidateRecord();
        test3ValidateRecord.setPostcode(test3PostcodeRequest);
        test3ValidateRecord.setValid(false);
        List<ValidateRecord> test3ValidateList = new ArrayList<>();
        test3ValidateList.add(test3ValidateRecord);

        when(mockAddressRecordService.validateAddressRecords(test3PostcodeRequest)).thenReturn(test3ValidateList);

        mockAddressRecordService = mock(AddressRecordService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(restController).build();

    }

    /**
     * Tests RESTController.getPing()
     */
    @Test
    public void Ping_PongIsGot_Passes() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.result.response", is("pong")));
    }

    /**
     * Tests RESTController.getPostcode() with a real postcode
     */
    @Test
    public void Postcode_RealPostcodeIsGot_Passes() throws Exception {

        mockMvc.perform(get("/postcode/" + test1PostcodeRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.result[0].postcode", is(test1PostcodeResponse)));

    }

    /**
     * Tests RESTController.getPostcode() with a real postcode and building number
     */
    @Test
    public void PostcodeAndBuilding_RealPostcodeIsGot_Passes() throws Exception {

        mockMvc.perform(get("/postcode/" + test2PostcodeRequest + "/" + test2BuildingNumberRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.result[0].postcode", is(test2PostcodeResponse)))
                .andExpect(jsonPath("$.result[0].buildingNumber", is(test2BuildingNumberResponse)));

    }

    /**
     * Tests RESTController.getPostcode() with a false postcode
     */
    @Test
    public void Postcode_FalsePostcodeIsNotGot_Passes() throws Exception {
        mockMvc.perform(get("/postcode/" + test3PostcodeRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(404)));
    }

    /**
     * Tests RESTController.getPostcode() with a false postcode and building number
     */
    @Test
    public void PostcodeAndBuilding_FalsePostcodeIsNotGot_Passes() throws Exception {

        mockMvc.perform(get("/postcode/" + test3PostcodeRequest + "/" + test3BuildingNumberRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(404)));

    }

    /**
     * Tests RESTController.getPostcode() with a real udprn
     */
    @Test
    public void UDPRN_RealPostcodeIsGot_Passes() throws Exception {

        mockMvc.perform(get("/udprn/" + test1UPDRNRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.result[0].udprn", is(test1UPDRNResponse)));

    }

    /**
     * Tests RESTController.getPostcode() with a false UDPRN
     */
    @Test
    public void UDPRN_FalsePostcodeIsNotGot_Passes() throws Exception {

        mockMvc.perform(get("/udprn/" + test3UPDRNRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(404)));
    }

    /**
     * Tests RESTController.validatePostcode() with a real postcode
     */
    @Test
    public void Postcode_RealPostcodeIsValidated_Passes() throws Exception {

        mockMvc.perform(get("/validate/" + test1PostcodeRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.result[0].valid", is(true)));

    }

    /**
     * Tests RESTController.validatePostcode() with a false postcode
     */
    @Test
    public void Postcode_FalsePostcodeIsValidated_Passes() throws Exception {

        mockMvc.perform(get("/validate/" + test3PostcodeRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.result[0].valid", is(false)));

    }

}