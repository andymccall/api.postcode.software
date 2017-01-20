package software.postcode.api.service;

import software.postcode.api.model.AddressRecord;

/**
 * Created by andymccall on 20/01/2017.
 */
public interface AddressRecordService {

    public AddressRecord getAddressRecord(String postcode);

}
