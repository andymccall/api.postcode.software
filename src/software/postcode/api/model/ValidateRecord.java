package software.postcode.api.model;

/**
 * Created by andymccall on 03/02/2017.
 */
public class ValidateRecord {

    private String internalPostcode;
    private String postcode;
    private String buildingNumber;
    private Boolean valid;

    public void setInternalPostcode(String internalPostcode) {
        this.internalPostcode = internalPostcode;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {

        this.postcode = postcode;
        this.setInternalPostcode(postcode.replaceAll("\\s+",""));

    }

    public String getBuildingNumber() { return this.buildingNumber; }

    public void setBuildingNumber(String buildingNumber) { this.buildingNumber = buildingNumber; }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "ValidateRecord{" +
                "postcode='" + postcode + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", valid=" + valid +
                '}';
    }
}
