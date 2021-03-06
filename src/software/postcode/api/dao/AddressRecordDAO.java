package software.postcode.api.dao;

import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.ValidateRecord;

import java.util.List;

/**
 * The AddressRecordDAO interface is a contract that contains all the methods
 * that need to be implemented for the AddressRecordDAO to function.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-28
 */
public interface AddressRecordDAO {

    public List<AddressRecord> getAddressRecords(String postcode);
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber);
    public List<AddressRecord> getAddressRecordsByUDPRN(String UDPRN);
    public List<AddressRecord> getRandomAddressRecords(int number);
    public List<ValidateRecord> validateAddressRecords(String postcode);
    public List<ValidateRecord> validateAddressRecords(String postcode, String buildingNumber);

}
