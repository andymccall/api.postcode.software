package software.postcode.api.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * The JsonResponseTest class is a test class that tests JsonResponse.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-25
 */

public class JsonResponseTest {

    // Static test1
    final private int test1status = 200;
    final private String test1error = "Test error 1!";

    // Random test2
    private int test2status;
    private String test2error;

    // Test for exception
    final private String test3error = "";

    private JsonResponse test1JsonResponse;
    private JsonResponse test2JsonResponse;
    private JsonResponse test3JsonResponse;

    /**
     * Sets up objects needed for the tests.
     */
    @Before
    public void setUp() throws Exception {

        // Used for testing getStatus and getError
        test1JsonResponse = new JsonResponse() {
            @Override
            public String toString() {
                return null;
            }
        };
        test1JsonResponse.setStatus(test1status);
        test1JsonResponse.setError(test1error);

        // Test getStatus and setStatus with random values
        Random random = new Random();
        test2status = random.nextInt(500);
        test2error = RandomStringUtils.random(8, true, false);

        test2JsonResponse = new JsonResponse() {
            @Override
            public String toString() {
                return null;
            }
        };

        // Used for testing setError with null or empty string
        test3JsonResponse = new JsonResponse() {
            @Override
            public String toString() {
                return null;
            }
        };
    }

    /**
     * Tests JsonResponse.getStatus() with a known value
     */
    @Test
    public void getStatus() throws Exception {
        Assert.assertEquals(test1JsonResponse.getStatus(), test1status);
    }

    /**
     * Tests JsonResponse.getError() with a known value
     */
    @Test
    public void getError() throws Exception {
        Assert.assertEquals(test1JsonResponse.getError(), test1error);
    }

    /**
     * Tests JsonResponse.setStatus() with a unique value
     */
    @Test
    public void setStatus() throws Exception {
        test2JsonResponse.setStatus(test2status);
        Assert.assertEquals(test2JsonResponse.getStatus(), test2status);
    }

    /**
     * Tests JsonResponse.setStatus() with a unique value
     */
    @Test
    public void setError_ErrorIsSet_Passes() throws Exception {
        test2JsonResponse.setError(test2error);
        Assert.assertEquals(test2JsonResponse.getError(), test2error);
    }

    /**
     * Tests JsonResponse.setError() will not accept an empty string
     */
    @Test(expected = IllegalArgumentException.class)
    public void setError_NullOrEmptyError_ExceptionThrown() throws IllegalArgumentException {
        test3JsonResponse.setError(test3error);
    }

}