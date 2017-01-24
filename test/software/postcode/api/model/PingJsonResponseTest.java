package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The PingJsonResponseTest class is a test class that tests PingJsonResponse
 * without the dependency of the Ping class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-24
 */

public class PingJsonResponseTest {

    final private static String test1Response = "test1";
    final private static String test2Response = "test2";

    private Ping mock1Ping;
    private Ping mock2Ping;
    private PingJsonResponse test1PingJsonResponse;
    private PingJsonResponse test2PingJsonResponse;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        mock1Ping = mock(Ping.class);
        when(mock1Ping.getResponse()).thenReturn(test1Response);

        mock2Ping = mock(Ping.class);
        when(mock2Ping.getResponse()).thenReturn(test2Response);

        test1PingJsonResponse = new PingJsonResponse();
        test1PingJsonResponse.setResult(mock1Ping);

        test2PingJsonResponse = new PingJsonResponse();

    }

    /**
     * Tests PingJsonResponse.getResult()
     */
    @Test
    public void getResult() throws Exception {
        Assert.assertEquals("getResult() has failed",
                test1PingJsonResponse.getResult().getResponse(), test1Response);
    }

    /**
     * Tests PingJsonResponse.setResult()
     */
    @Test
    public void setResult() throws Exception {
        test2PingJsonResponse.setResult(mock2Ping);
        Assert.assertEquals("setResult() has failed",
                test2PingJsonResponse.getResult().getResponse(), test2Response);
    }

}