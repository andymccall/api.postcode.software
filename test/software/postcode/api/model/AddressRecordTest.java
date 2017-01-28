package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by andymccall on 28/01/2017.
 */
public class AddressRecordTest {

    private final String test1Postcode = "PL1 1AB";
    private final String test1PostTown = "PLYMOUTH";
    private final String test1ThoroughfareAndDescriptor = "St. Andrews Cross";
    private final String test1BuildingNumber = "5";
    private final String test1OrganisationName = "Post Office";
    private final String test1UDPRN = "18911184";
    private final String test1PostcodeType = "L";
    private final String test1DeliveryPointSuffix = "1A";

    private final String test1Address = "PL1 1AB,PLYMOUTH,,,St. Andrews Cross,,5,,,,,Post Office,18911184,L, ,1A";

    private AddressRecord referenceAddressRecord;
    private AddressRecord test1AddressRecord;

    @Before
    public void setUp() throws Exception {

        // Set up the reference record with the reference data
        String[] test1AddressArray = test1Address.split(Pattern.quote(","));
        referenceAddressRecord = new AddressRecord().populateAddressRecord(test1AddressArray);
        referenceAddressRecord.populateAddressRecord(test1AddressArray);

        // Set up test1AddressRecord for most of the tests
        test1AddressRecord = new AddressRecord();

    }

    @Test
    public void getPostcode_PostcodeIsGot_Passes() throws Exception {
        Assert.assertEquals("getPostcode() has failed",
                test1Postcode, referenceAddressRecord.getPostcode());
    }

    @Test
    public void setPostcode_PostcodeIsSet_Passes() throws Exception {
        test1AddressRecord.setPostcode(test1Postcode);
        Assert.assertEquals("setPostcode() has failed",
                test1Postcode, test1AddressRecord.getPostcode());
    }

    @Test
    public void getPostTown_PostTownIsGot_Passes() throws Exception {
        Assert.assertEquals("getPostTown() has failed",
                test1PostTown, referenceAddressRecord.getPostTown());
    }

    @Test
    public void setPostTown_PostTownIsGot_Passes() throws Exception {
        test1AddressRecord.setPostTown(test1PostTown);
        Assert.assertEquals("setPostTown() has failed",
                test1PostTown, test1AddressRecord.getPostTown());
    }

//    @Test
//    public void getDependantLocality() throws Exception {
//
//    }
//
//    @Test
//    public void setDependantLocality() throws Exception {
//
//    }
//
//    @Test
//    public void getDoubleDependentLocality() throws Exception {
//
//    }
//
//    @Test
//    public void setDoubleDependentLocality() throws Exception {
//
//    }

    @Test
    public void getThoroughfareAndDescriptor_ThoroughfareAndDescriptorIsGot_Passes() throws Exception {
        Assert.assertEquals("getThoroughfareAndDescriptor() has failed",
                test1ThoroughfareAndDescriptor, referenceAddressRecord.getThoroughfareAndDescriptor());
    }

    @Test
    public void setThoroughfareAndDescriptor_ThoroughfareAndDescriptorIsSet_Passes() throws Exception {
        test1AddressRecord.setThoroughfareAndDescriptor(test1ThoroughfareAndDescriptor);
        Assert.assertEquals("setThoroughfareAndDescriptor() has failed",
                test1ThoroughfareAndDescriptor, test1AddressRecord.getThoroughfareAndDescriptor());
    }

//    @Test
//    public void getDependentThoroughfareAndDescriptor() throws Exception {
//
//    }
//
//    @Test
//    public void setDependentThoroughfareAndDescriptor() throws Exception {
//
//    }
//
    @Test
    public void getBuildingNumber_BuildingNumberIsGot_Passes() throws Exception {
        Assert.assertEquals("getBuildingNumber() has failed",
            test1BuildingNumber, referenceAddressRecord.getBuildingNumber());
    }

    @Test
    public void setBuildingNumber_BuildingNumberIsSet_Passes() throws Exception {
        test1AddressRecord.setBuildingNumber(test1BuildingNumber);
        Assert.assertEquals("setBuildingNumber() has failed",
                test1BuildingNumber, test1AddressRecord.getBuildingNumber());
    }

//    @Test
//    public void getBuildingName() throws Exception {
//
//    }
//
//    @Test
//    public void setBuildingName() throws Exception {
//
//    }
//
//    @Test
//    public void getSubBuildingName() throws Exception {
//
//    }
//
//    @Test
//    public void setSubBuildingName() throws Exception {
//
//    }
//
//    @Test
//    public void getPOBox() throws Exception {
//
//    }
//
//    @Test
//    public void setPOBox() throws Exception {
//
//    }
//
//    @Test
//    public void getDepartmentName() throws Exception {
//
//    }
//
//    @Test
//    public void setDepartmentName() throws Exception {
//
//    }
//
    @Test
    public void getOrganisationName_OrganisationNameIsGot_Passes() throws Exception {
        Assert.assertEquals("getOrganisationName() has failed",
                test1OrganisationName, referenceAddressRecord.getOrganisationName());
    }

    @Test
    public void setOrganisationName_OrganisationNameIsSet_Passes() throws Exception {
        test1AddressRecord.setOrganisationName(test1OrganisationName);
        Assert.assertEquals("setOrganisationName() has failed",
                test1OrganisationName, test1AddressRecord.getOrganisationName());
    }

    @Test
    public void getUDPRN_UDPRNIsGot_Passes() throws Exception {
        Assert.assertEquals("getUDPRN() has failed",
                test1UDPRN, referenceAddressRecord.getUDPRN());
    }

    @Test
    public void setUDPRN_UDPRNIsGot_Passes() throws Exception {
        test1AddressRecord.setUDPRN(test1UDPRN);
        Assert.assertEquals("setUDPRN() has failed",
                test1UDPRN, test1AddressRecord.getUDPRN());
    }

    @Test
    public void getPostcodeType_PostcodeTypeIsGot_Passes() throws Exception {
        Assert.assertEquals("getPostcodeType() has failed",
                test1PostcodeType, String.valueOf(referenceAddressRecord.getPostcodeType()));
    }

    @Test
    public void setPostcodeType_PostcodeTypeIsSet_Passes() throws Exception {
        test1AddressRecord.setPostcodeType(test1PostcodeType.charAt(0));
        Assert.assertEquals("setPostcodeType() has failed",
                test1PostcodeType, String.valueOf(test1AddressRecord.getPostcodeType()));
    }

//
//    @Test
//    public void getSUOrganisationIndicator() throws Exception {
//
//    }
//
//    @Test
//    public void setSUOrganisationIndicator() throws Exception {
//
//    }
//

    @Test
    public void getDeliveryPointSuffix_DeliveryPointSuffixIsGot_Passes() throws Exception {
        Assert.assertEquals("getDeliveryPointSuffix() has failed",
                test1DeliveryPointSuffix, referenceAddressRecord.getDeliveryPointSuffix());
    }

    @Test
    public void setDeliveryPointSuffix_DeliveryPointSuffixIsSet_Passes() throws Exception {
        test1AddressRecord.setDeliveryPointSuffix(test1DeliveryPointSuffix);
        Assert.assertEquals("setDeliveryPointSuffix() has failed",
                test1DeliveryPointSuffix, test1AddressRecord.getDeliveryPointSuffix());
    }

}