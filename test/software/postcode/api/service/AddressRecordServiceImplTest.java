package software.postcode.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.postcode.api.dao.AddressRecordDAO;
import software.postcode.api.model.AddressRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.Mockito.when;

/**
 * The AddressRecordServiceImpl class is a class that implements all the methods
 * in the AddressRecordService interface.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-28
 */
public class AddressRecordServiceImplTest {

    @Mock
    private AddressRecordDAO mockAdddressRecordDAO;

    @InjectMocks
    private AddressRecordService addressRecordServiceImpl = new AddressRecordServiceImpl();

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

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        // Set up the response for test1
        String[] test1AddressArray = test1Address.split(Pattern.quote(","));
        AddressRecord test1AddressRecord = new AddressRecord().populateAddressRecord(test1AddressArray);
        List<AddressRecord> test1AddressList = new ArrayList<>();
        test1AddressList.add(test1AddressRecord);

        when(mockAdddressRecordDAO.getAddressRecords(test1PostcodeRequest)).thenReturn(test1AddressList);
        when(mockAdddressRecordDAO.getAddressRecordsByUDPRN(test1UPDRNRequest)).thenReturn(test1AddressList);

        // Set up the response for test2
        String[] test2AddressArray = test2Address.split(Pattern.quote(","));
        AddressRecord test2AddressRecord = new AddressRecord().populateAddressRecord(test2AddressArray);
        List<AddressRecord> test2AddressList = new ArrayList<>();
        test2AddressList.add(test2AddressRecord);

        when(mockAdddressRecordDAO.getAddressRecords(test2PostcodeRequest,test2BuildingNumberRequest)).thenReturn(test2AddressList);

    }

    /**
     * Tests AddressRecordServiceImpl.getAddressRecords() with a real postcode
     */
    @Test
    public void AddressRecordServiceImpl_GetRealAddressRecordsByPostcode_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getAddressRecords(test1PostcodeRequest);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.get(0).getPostcode(), test1PostcodeResponse);

    }

    /**
     * Tests AddressRecordServiceImpl.getAddressRecords() with a false postcode
     */
    @Test
    public void AddressRecordServiceImpl_GetFalseAddressRecordsByPostcode_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getAddressRecords(test3PostcodeRequest);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.size(), 0);

    }

    /**
     * Tests AddressRecordServiceImpl.getAddressRecords() with a real postcode and building number
     */
    @Test
    public void AddressRecordServiceImpl_GetRealAddressRecordsByPostcodeAndBuilding_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getAddressRecords(test2PostcodeRequest,test2BuildingNumberRequest);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.get(0).getPostcode(), test2PostcodeResponse);

    }

    /**
     * Tests AddressRecordServiceImpl.getAddressRecords() with a false postcode and building number
     */
    @Test
    public void AddressRecordServiceImpl_GetFalseAddressRecordsByPostcodeAndBuilding_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getAddressRecords(test3PostcodeRequest,test3BuildingNumberRequest);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.size(), 0);

    }

    /**
     * Tests AddressRecordServiceImpl.getAddressRecordsByUDPRN() with a real UDPRN
     */
    @Test
    public void AddressRecordServiceImpl_GetRealAddressRecordsByUDPRN_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getAddressRecordsByUDPRN(test1UPDRNRequest);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.get(0).getUDPRN(), test1UPDRNResponse);

    }

    /**
     * Tests AddressRecordServiceImpl.getAddressRecordsByUDPRN() with a false UDPRN
     */
    @Test
    public void AddressRecordServiceImpl_GetFalseAddressRecordsByUDPRN_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getAddressRecordsByUDPRN(test3UPDRNRequest);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.size(),0);

    }

}