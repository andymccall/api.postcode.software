package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The PingTest class is a test class that tests Ping.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-24
 */
public class PingTest {

    private Ping testPing;

    /**
     * Sets up objects and mocks external dependencies needed
     * for the tests.
     */
    @Before
    public void setUp() throws Exception {
        testPing = new Ping() {
            @Override
            public String toString() {
                return null;
            }
        };
    }

    /**
     * Tests Ping.getResponse()
     */
    @Test
    public void getResponse() throws Exception {
        Assert.assertEquals(testPing.getResponse(), "pong");
    }

}