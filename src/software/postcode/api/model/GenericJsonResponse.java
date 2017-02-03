package software.postcode.api.model;

import java.util.List;

/**
 * Created by andymccall on 20/01/2017.
 */
public class GenericJsonResponse<T> extends JsonResponse {

    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GenericJsonResponse{" +
                "status=" + super.getStatus() +
                ", result=" + result +
                ", error='" + super.getError() +
                '}';
    }
}
