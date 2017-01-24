package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andymccall on 23/01/2017.
 */
public class PingTest {

    private Ping testPing;

    @Before
    public void setUp() throws Exception {
        testPing = new Ping() {
            @Override
            public String toString() {
                return null;
            }
        };
    }

    @Test
    public void getResponse() throws Exception {
        Assert.assertEquals(testPing.getResponse(), "pong");
    }


}