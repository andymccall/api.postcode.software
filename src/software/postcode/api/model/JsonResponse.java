package software.postcode.api.model;

/**
 * The JsonResponse class is a superclass that contains all the common details
 * about an JsonResponse.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-23
 */

public abstract class JsonResponse {

    private int status;
    private String error;

    /**
     * Gets the status of the JsonResponse.
     * @return int containing status.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status of the JsonResponse.
     * @param status containing status of JsonResponse
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the error of the JsonResponse.
     * @return String containing error.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error of the JsonResponse.
     * @param error containing error of JsonResponse, must not be empty and
     *               cannot contain only whitespace.
     * @exception IllegalArgumentException if error is empty or contains only whitespace.
     */
    public void setError(String error) {

        // Check if the error only contains whitespace or is empty
        // everything else is valid
        if (error.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid error: " + error);
        }
        this.error = error;

    }

    abstract public String toString();

}