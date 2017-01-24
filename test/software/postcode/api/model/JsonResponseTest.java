package software.postcode.api.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andymccall on 23/01/2017.
 */
public class JsonResponseTest {

    // Constants
    final private static int test1status = 200;
    final private static String test1error = "Test error 1!";

    final private static int test2status = 500;
    final private static String test2error = "Test error 2!";


    private JsonResponse test1JsonResponse;
    private JsonResponse test2JsonResponse;

    @Before
    public void setUp() throws Exception {
        test1JsonResponse = new JsonResponse() {
            @Override
            public String toString() {
                return null;
            }
        };
        test1JsonResponse.setStatus(test1status);
        test1JsonResponse.setError(test1error);

        test2JsonResponse = new JsonResponse() {
            @Override
            public String toString() {
                return null;
            }
        };
    }

    @Test
    public void getStatus() throws Exception {
        Assert.assertEquals(test1JsonResponse.getStatus(), test1status);
    }

    @Test
    public void getError() throws Exception {
        Assert.assertEquals(test1JsonResponse.getError(), test1error);
    }

    @Test
    public void setStatus() throws Exception {
        test2JsonResponse.setStatus(test2status);
        Assert.assertEquals(test2JsonResponse.getStatus(), test2status);
    }

    @Test
    public void setError() throws Exception {
        test2JsonResponse.setError(test2error);
        Assert.assertEquals(test2JsonResponse.getError(), test2error);
    }

}