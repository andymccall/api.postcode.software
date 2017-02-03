package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andymccall on 03/02/2017.
 */
public class ValidateRecordTest {

    private final String test1Postcode = "PL1 1AB";
    private final Boolean test1Valid = true;
    private final Boolean test1Invalid = false;

    private ValidateRecord reference1ValidateRecord;
    private ValidateRecord test1ValidateRecord;

    @Before
    public void setUp() throws Exception {

        reference1ValidateRecord = new ValidateRecord();
        reference1ValidateRecord.setPostcode(test1Postcode);
        reference1ValidateRecord.setValid(true);

        test1ValidateRecord = new ValidateRecord();

    }

    @Test
    public void getPostcode_PostcodeIsGot_Passes() throws Exception {
        Assert.assertEquals("getPostcode() has failed",
                test1Postcode, reference1ValidateRecord.getPostcode());
    }

    @Test
    public void setPostcode_PostcodeIsSet_Passes() throws Exception {
        test1ValidateRecord.setPostcode(test1Postcode);
        Assert.assertEquals("setPostcode() has failed",
                test1Postcode, test1ValidateRecord.getPostcode());
    }

    @Test
    public void Valid_VaidIsGot_Passes() throws Exception {
        Assert.assertEquals("getValid() has failed",
                test1Valid, reference1ValidateRecord.getValid());
    }

    @Test
    public void Valid_VaidIsSetValid_Passes() throws Exception {
        test1ValidateRecord.setValid(test1Valid);
        Assert.assertEquals("getValid() has failed",
                test1Valid, reference1ValidateRecord.getValid());
    }

    @Test
    public void Valid_VaidIsSetInValid_Passes() throws Exception {
        test1ValidateRecord.setValid(test1Invalid);
        Assert.assertEquals("getValid() has failed",
                test1Invalid, test1ValidateRecord.getValid());
    }

    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals( "toString() has failed",
                "ValidateRecord{postcode='PL1 1AB', valid=true}", reference1ValidateRecord.toString());
    }

}