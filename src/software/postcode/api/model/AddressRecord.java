package software.postcode.api.model;

import org.springframework.data.annotation.Id;

/**
 * The AddressRecord class is a class that implements the
 * address.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-29
 */
public class AddressRecord {

    private long internalSequence;
    private String internalPostcode;
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
    @Id
    private String UDPRN;
    private char postcodeType;
    private char SUOrganisationIndicator;
    private String deliveryPointSuffix;

    public void setInternalSequence(long internalSequence) { this.internalSequence = internalSequence; }

    public void setInternalPostcode(String internalPostcode) { this.internalPostcode = internalPostcode; }

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

    /**
     * Used to populate and AddressRecord
     */
    public AddressRecord populateAddressRecord(String[] addressArray) {

        AddressRecord addressRecord = new AddressRecord();

        if (addressArray[0] != null) { addressRecord.setInternalPostcode(addressArray[0].replaceAll("\\s+","")); }

        if (addressArray[0] != null) { addressRecord.setPostcode(addressArray[0]); }

        if (addressArray[1] != null) { addressRecord.setPostTown(addressArray[1]); }

        if (addressArray[2] != null) { addressRecord.setDependantLocality(addressArray[2]); }

        if (addressArray[3] != null) { addressRecord.setDoubleDependentLocality(addressArray[3]); }

        if (addressArray[4] != null) { addressRecord.setThoroughfareAndDescriptor(addressArray[4]); }

        if (addressArray[5] != null) { addressRecord.setDependentThoroughfareAndDescriptor(addressArray[5]); }

        if (addressArray[6] != null) { addressRecord.setBuildingNumber(addressArray[6]); }

        if (addressArray[7] != null) { addressRecord.setBuildingName(addressArray[7]); }

        if (addressArray[8] != null) { addressRecord.setSubBuildingName(addressArray[8]); }

        if (addressArray[9] != null) { addressRecord.setPOBox(addressArray[9]); }

        if (addressArray[10] != null) { addressRecord.setDepartmentName(addressArray[10]); }

        if (addressArray[11] != null) { addressRecord.setOrganisationName(addressArray[11]); }

        if (addressArray[12] != null) { addressRecord.setUDPRN(addressArray[12]); }

        if (addressArray[13] != null) { addressRecord.setPostcodeType(addressArray[13].charAt(0)); }

        if (addressArray[14] != null) { addressRecord.setSUOrganisationIndicator(addressArray[14].charAt(0)); }

        if (addressArray[15] != null) { addressRecord.setDeliveryPointSuffix(addressArray[15]); }

        return addressRecord;

    }

}
