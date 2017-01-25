package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The PingJsonResponseTest class is a test class that tests PingJsonResponse
 *
 * @author  Andy McCall
 * @version 0.3
 * @since   2017-01-25
 */
public class PingJsonResponseTest {

    final private String expectedResponse = "pong";

    private Ping testPing;
    private PingJsonResponse test1PingJsonResponse;
    private PingJsonResponse test2PingJsonResponse;

    /**
     * Sets up objects needed for the tests.
     */
    @Before
    public void setUp() throws Exception {

        // Used for testing getResult with existing Ping()
        testPing = new Ping();
        test1PingJsonResponse = new PingJsonResponse();
        test1PingJsonResponse.setResult(testPing);

        // Used for testing setResult with Ping()
        test2PingJsonResponse = new PingJsonResponse();

    }

    /**
     * Tests PingJsonResponse.getResult() with a known value
     */
    @Test
    public void getResult() throws Exception {
        Assert.assertEquals("getResult() has failed",
                test1PingJsonResponse.getResult().getResponse(), expectedResponse);
    }

    /**
     * Tests PingJsonResponse.setResult() with a Ping()
     */
    @Test
    public void setResult() throws Exception {
        test2PingJsonResponse.setResult(testPing);
        Assert.assertEquals("setResult() has failed",
                test2PingJsonResponse.getResult().getResponse(), expectedResponse);
    }

    /**
     * Tests PingJsonResponse.toString()
     */
    @Test
    public void toString_StringReturned_Passes() throws Exception {
        Assert.assertEquals( "toString() has failed",
                "PingJsonResponse{status=0, result='Ping{response=pong}', error='null}",
                test1PingJsonResponse.toString());
    }

}