package software.postcode.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import software.postcode.api.Application;
import software.postcode.api.model.AddressRecord;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

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

    @Autowired
    private WebApplicationContext webApplicationContext;

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

        this.mockMvc = webAppContextSetup(webApplicationContext).build();

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

//    /**
//     * Tests RESTController.getPostcode() with a real postcode
//     */
//    @Test
//    public void Postcode_RealPostcodeIsGot_Passes() throws Exception {
//        mockMvc.perform(get("/postcode/" + test1Postcode))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.status", is(200)));
//    }

//    /**
//     * Tests RESTController.getPostcode() with a false postcode
//     */
//    @Test
//    public void Postcode_FalsePostcodeIsNotGot_Passes() throws Exception {
//        mockMvc.perform(get("/postcode/" + test2Postcode))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.status", is(404)));
//    }

    /**
     * Used to navigate JSON objects
     */
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

//    /**
//     * Used to populate and AddressRecord
//     */
//    private AddressRecord addressPopulator(String[] line) {
//
//        AddressRecord addressRecord = new AddressRecord();
//
//        addressRecord.setPostcode(line[0]);
//        addressRecord.setPostTown(line[1]);
//        addressRecord.setDependantLocality(line[2]);
//        addressRecord.setDoubleDependentLocality(line[3]);
//        addressRecord.setThoroughfareAndDescriptor(line[4]);
//        addressRecord.setDependentThoroughfareAndDescriptor(line[5]);
//        addressRecord.setBuildingNumber(line[6]);
//        addressRecord.setBuildingName(line[7]);
//        addressRecord.setSubBuildingName(line[8]);
//        addressRecord.setPOBox(line[9]);
//        addressRecord.setDepartmentName(line[10]);
//        addressRecord.setOrganisationName(line[11]);
//        addressRecord.setUDPRN(line[12]);
//        addressRecord.setPostcodeType(line[13].charAt(0));
//        addressRecord.setSUOrganisationIndicator(line[14].charAt(0));
//        addressRecord.setDeliveryPointSuffix(line[15]);
//
//        return addressRecord;
//
//    }

}