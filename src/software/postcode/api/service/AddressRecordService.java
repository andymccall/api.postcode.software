package software.postcode.api.service;

import software.postcode.api.model.AddressRecord;

import java.util.List;

/**
 * Created by andymccall on 20/01/2017.
 */
public interface AddressRecordService {

    public List<AddressRecord> getAddressRecords(String postcode);
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber);

}
