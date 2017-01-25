package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The AddressRecordJsonResponseTestTest class is a test class
 * that tests AddressRecordJsonResponseTest.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-25
 */
public class AddressRecordJsonResponseTest {

    private AddressRecord test1AddressRecord;
    private AddressRecordJsonResponse test1AddressRecordJsonResponse;

    /**
     * Sets up objects needed for the tests.
     */
    @Before
    public void setUp() throws Exception {

        List<AddressRecord> testAddressList = new ArrayList<>();

        test1AddressRecord = new AddressRecord();
        test1AddressRecordJsonResponse = new AddressRecordJsonResponse();

        test1AddressRecord.setPostcode("A");
        test1AddressRecord.setPostTown("A");
        test1AddressRecord.setDependantLocality("A");
        test1AddressRecord.setDoubleDependentLocality("A");
        test1AddressRecord.setThoroughfareAndDescriptor("A");
        test1AddressRecord.setDependentThoroughfareAndDescriptor("A");
        test1AddressRecord.setBuildingNumber("A");
        test1AddressRecord.setBuildingName("A");
        test1AddressRecord.setSubBuildingName("A");
        test1AddressRecord.setPOBox("A");
        test1AddressRecord.setDepartmentName("A");
        test1AddressRecord.setOrganisationName("A");
        test1AddressRecord.setUDPRN("A");
        test1AddressRecord.setPostcodeType("A".charAt(0));
        test1AddressRecord.setSUOrganisationIndicator("A".charAt(0));
        test1AddressRecord.setDeliveryPointSuffix("A");

        testAddressList.add(test1AddressRecord);

        test1AddressRecordJsonResponse.setResult(testAddressList);

    }

    @Test
    public void getResult() throws Exception {

    }

    @Test
    public void setResult() throws Exception {

    }

    /**
     * Tests AddressRecordJsonResponseTest.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals( "toString() has failed",
                "AddressRecordJsonResponse{status=0, result=[AddressRecord{postcode='A', postTown='A', dependantLocality='A', doubleDependentLocality='A', thoroughfareAndDescriptor='A', dependentThoroughfareAndDescriptor='A', buildingNumber=A, buildingName='A', subBuildingName='A', POBox='A', departmentName='A', organisationName='A', UDPRN=A, postcodeType=A, SUOrganisationIndicator=A, deliveryPointSuffix='A'}], error='null}",
                test1AddressRecordJsonResponse.toString());

    }

}