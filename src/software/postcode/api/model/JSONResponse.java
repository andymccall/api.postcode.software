package software.postcode.api.model;

import java.util.List;

/**
 * Created by andymccall on 20/01/2017.
 */
public class JSONResponse<T> {

    private int status;
    private List<T> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JSONResponse{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }
}
