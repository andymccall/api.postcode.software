package software.postcode.api.service;

import software.postcode.api.model.AddressRecord;

import java.util.List;

/**
 * The AddressRecordService interface is a contract that contains all the methods
 * that need to be implemented for the AddressRecordService to function.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-28
 */
public interface AddressRecordService {

    public List<AddressRecord> getAddressRecords(String postcode);
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber);
    public List<AddressRecord> getAddressRecordsByUDPRN(String UDPRN);

}
