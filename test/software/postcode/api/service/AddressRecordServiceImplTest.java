package software.postcode.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.postcode.api.dao.AddressRecordDAO;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.ValidateRecord;

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

        // Set up the response for test2
        String[] test3AddressArray = test2Address.split(Pattern.quote(","));
        AddressRecord test3AddressRecord = new AddressRecord().populateAddressRecord(test3AddressArray);
        List<AddressRecord> test3AddressList = new ArrayList<>();
        test3AddressList.add(test1AddressRecord);
        test3AddressList.add(test2AddressRecord);

        when(mockAdddressRecordDAO.getRandomAddressRecords(1)).thenReturn(test1AddressList);
        when(mockAdddressRecordDAO.getRandomAddressRecords(2)).thenReturn(test3AddressList);

        // Set up the response for validate test
        ValidateRecord test1ValidateRecord = new ValidateRecord();
        test1ValidateRecord.setPostcode(test1PostcodeRequest);
        test1ValidateRecord.setValid(true);
        List<ValidateRecord> test1ValidateList = new ArrayList<>();
        test1ValidateList.add(test1ValidateRecord);

        // Set up the response for false validate test
        ValidateRecord test3ValidateRecord = new ValidateRecord();
        test3ValidateRecord.setPostcode(test3PostcodeRequest);
        test3ValidateRecord.setValid(false);
        List<ValidateRecord> test3ValidateList = new ArrayList<>();
        test3ValidateList.add(test3ValidateRecord);

        when(mockAdddressRecordDAO.validateAddressRecords(test1PostcodeRequest)).thenReturn(test1ValidateList);
        when(mockAdddressRecordDAO.validateAddressRecords(test3PostcodeRequest)).thenReturn(test3ValidateList);


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

    /**
     * Tests AddressRecordServiceImpl.getRandomAddressRecords() requesting 1 postcode
     */
    @Test
    public void AddressRecordServiceImpl_GetOneRandomAddressRecords_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getRandomAddressRecords(1);

        Assert.assertEquals("getAddressRecords() has failed",
                resultsList.size(), 1);

    }

    /**
     * Tests AddressRecordServiceImpl.getRandomAddressRecords() requesting 3 postcode2
     */
    @Test
    public void AddressRecordServiceImpl_GetTwoRandomAddressRecords_Passes() throws Exception {
        List<AddressRecord> resultsList = addressRecordServiceImpl.getRandomAddressRecords(2);

        Assert.assertEquals("getRandomAddressRecords() has failed",
                resultsList.size(), 2);

    }

    /**
     * Tests AddressRecordServiceImpl.validateAddressRecords() with a true postcode
     */
    @Test
    public void AddressRecordServiceImpl_ValidateTrueAddressRecords_Passes() throws Exception {

        List<ValidateRecord> resultsList = addressRecordServiceImpl.validateAddressRecords(test1PostcodeRequest);

        Assert.assertEquals("validateAddressRecords() has failed",
                resultsList.get(0).getValid(),true);

    }

    /**
     * Tests AddressRecordServiceImpl.validateAddressRecords() with a false postcode
     */
    @Test
    public void AddressRecordServiceImpl_ValidateFalseAddressRecords_Passes() throws Exception {

        List<ValidateRecord> resultsList = addressRecordServiceImpl.validateAddressRecords(test3PostcodeRequest);

        Assert.assertEquals("validateAddressRecords() has failed",
                resultsList.get(0).getValid(),false);

    }

}