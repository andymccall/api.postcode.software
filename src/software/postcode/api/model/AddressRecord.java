package software.postcode.api.model;

/**
 * Created by andymccall on 20/01/2017.
 */
public class AddressRecord {

    private String postcode;
    private String postTown;
    private String dependantLocality;
    private String doubleDependentLocality;
    private String thoroughfareAndDescriptor;
    private String dependentThoroughfareAndDescriptor;
    private String buildingNumber;
    private String buildingName;
    private String subBuildingName;
    private String POBox;
    private String departmentName;
    private String organisationName;
    private String UDPRN;
    private char postcodeType;
    private char SUOrganisationIndicator;
    private String deliveryPointSuffix;


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostTown() {
        return postTown;
    }

    public void setPostTown(String postTown) {
        this.postTown = postTown;
    }

    public String getDependantLocality() {
        return dependantLocality;
    }

    public void setDependantLocality(String dependantLocality) {
        this.dependantLocality = dependantLocality;
    }

    public String getDoubleDependentLocality() {
        return doubleDependentLocality;
    }

    public void setDoubleDependentLocality(String doubleDependentLocality) {
        this.doubleDependentLocality = doubleDependentLocality;
    }

    public String getThoroughfareAndDescriptor() {
        return thoroughfareAndDescriptor;
    }

    public void setThoroughfareAndDescriptor(String thoroughfareAndDescriptor) {
        this.thoroughfareAndDescriptor = thoroughfareAndDescriptor;
    }

    public String getDependentThoroughfareAndDescriptor() {
        return dependentThoroughfareAndDescriptor;
    }

    public void setDependentThoroughfareAndDescriptor(String dependentThoroughfareAndDescriptor) {
        this.dependentThoroughfareAndDescriptor = dependentThoroughfareAndDescriptor;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getSubBuildingName() {
        return subBuildingName;
    }

    public void setSubBuildingName(String subBuildingName) {
        this.subBuildingName = subBuildingName;
    }

    public String getPOBox() {
        return POBox;
    }

    public void setPOBox(String POBox) {
        this.POBox = POBox;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getUDPRN() {
        return UDPRN;
    }

    public void setUDPRN(String UDPRN) {
        this.UDPRN = UDPRN;
    }

    public char getPostcodeType() {
        return postcodeType;
    }

    public void setPostcodeType(char postcodeType) {
        this.postcodeType = postcodeType;
    }

    public char getSUOrganisationIndicator() {
        return SUOrganisationIndicator;
    }

    public void setSUOrganisationIndicator(char SUOrganisationIndicator) {
        this.SUOrganisationIndicator = SUOrganisationIndicator;
    }

    public String getDeliveryPointSuffix() {
        return deliveryPointSuffix;
    }

    public void setDeliveryPointSuffix(String deliveryPointSuffix) {
        this.deliveryPointSuffix = deliveryPointSuffix;
    }

    @Override
    public String toString() {
        return "AddressRecord{" +
                "postcode='" + postcode + '\'' +
                ", postTown='" + postTown + '\'' +
                ", dependantLocality='" + dependantLocality + '\'' +
                ", doubleDependentLocality='" + doubleDependentLocality + '\'' +
                ", thoroughfareAndDescriptor='" + thoroughfareAndDescriptor + '\'' +
                ", dependentThoroughfareAndDescriptor='" + dependentThoroughfareAndDescriptor + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", buildingName='" + buildingName + '\'' +
                ", subBuildingName='" + subBuildingName + '\'' +
                ", POBox='" + POBox + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", organisationName='" + organisationName + '\'' +
                ", UDPRN=" + UDPRN +
                ", postcodeType=" + postcodeType +
                ", SUOrganisationIndicator=" + SUOrganisationIndicator +
                ", deliveryPointSuffix='" + deliveryPointSuffix + '\'' +
                '}';
    }
}
