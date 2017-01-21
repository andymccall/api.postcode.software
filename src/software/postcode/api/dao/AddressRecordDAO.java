package software.postcode.api.dao;

import software.postcode.api.model.AddressRecord;

import java.util.List;

/**
 * Created by andymccall on 20/01/2017.
 */
public interface AddressRecordDAO {

    public List<AddressRecord> getAddressRecords(String postcode);
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber);

}
