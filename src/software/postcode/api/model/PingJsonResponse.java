package software.postcode.api.model;

/**
 * Created by andymccall on 22/01/2017.
 */
public class PingJsonResponse extends JsonResponse {

    private Ping result;

    public Ping getResult() {
        return result;
    }

    public void setResult(Ping result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PingJsonResponse{" +
                "status=" + super.getStatus() +
                ", result='" + result + '\'' +
                ", error='" + super.getError() +
                '}';
    }
}
