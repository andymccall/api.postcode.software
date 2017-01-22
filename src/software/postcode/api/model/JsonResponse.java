package software.postcode.api.model;

/**
 * Created by andymccall on 22/01/2017.
 */
public abstract class JsonResponse {

    private int status;
    private String error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    abstract public String toString();

}