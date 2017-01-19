package software.postcode.api.model;

/**
 * Created by andymccall on 19/01/2017.
 */
public class Ping {

    private String response="pong";

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "Ping{" +
                "response=" + response +
                '}';
    }

}
