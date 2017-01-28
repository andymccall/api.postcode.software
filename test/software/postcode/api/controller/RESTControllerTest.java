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
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import software.postcode.api.Application;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.service.AddressRecordService;

import java.io.IOException;
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
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
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
    private final String test1Postcode = "PL11AB";
    private final String test2Postcode = "FY00LX";

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

        this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();

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

        String[] test1AddressArray = test1Address.split(Pattern.quote(","));
        AddressRecord test1AddressRecord = new AddressRecord().populateAddressRecord(test1AddressArray);
        List<AddressRecord> test1AddressList = new ArrayList<>();
        test1AddressList.add(test1AddressRecord);

        this.mockAddressRecordService = mock(AddressRecordService.class);

        when(this.mockAddressRecordService.getAddressRecords(test1Postcode)).thenReturn(test1AddressList);

        MvcResult result = mockMvc.perform(get("/postcode/" + test1Postcode))
                //.andExpect(status().isOk())
                //.andExpect(content().contentType(contentType))
                //.andExpect(jsonPath("$.status", is(200)))
                //.andExpect(jsonPath("$.result.postcode", is(test1Postcode)))
                .andReturn();

    }

    /**
     * Tests RESTController.getPostcode() with a false postcode
     */
    @Test
    public void Postcode_FalsePostcodeIsNotGot_Passes() throws Exception {
        mockMvc.perform(get("/postcode/" + test2Postcode))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is(404)));
    }

    /**
     * Used to navigate JSON objects
     */
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }


}