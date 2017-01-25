package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The PingJsonResponseTest class is a test class that tests PingJsonResponse
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-01-24
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

        testPing = new Ping();

        test1PingJsonResponse = new PingJsonResponse();
        test1PingJsonResponse.setResult(testPing);

        test2PingJsonResponse = new PingJsonResponse();

    }

    /**
     * Tests PingJsonResponse.getResult()
     */
    @Test
    public void getResult() throws Exception {
        Assert.assertEquals("getResult() has failed",
                test1PingJsonResponse.getResult().getResponse(), expectedResponse);
    }

    /**
     * Tests PingJsonResponse.setResult()
     */
    @Test
    public void setResult() throws Exception {
        test2PingJsonResponse.setResult(testPing);
        Assert.assertEquals("setResult() has failed",
                test2PingJsonResponse.getResult().getResponse(), expectedResponse);
    }

}