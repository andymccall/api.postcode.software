package software.postcode.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.postcode.api.dao.AddressRecordDAO;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.ValidateRecord;

import java.util.List;

/**
 * The AddressRecordServiceImpl class is a class that implements all the methods
 * in the AddressRecordService interface.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-28
 */
@Service("addressRecordService")
public class AddressRecordServiceImpl implements AddressRecordService {

    private static final Logger logger =
            LoggerFactory.getLogger(AddressRecordServiceImpl.class);

    @Autowired
    private AddressRecordDAO addressRecordDAO;

    /**
     * Gets the AddressRecords for a postcode.
     * @param postcode containing postcode to query.
     * @return List<AddressRecord> List containing AddressRecord objects.
     */
    @Override
    public List<AddressRecord> getAddressRecords(String postcode) {

        List<AddressRecord> addressRecords = addressRecordDAO.getAddressRecords(postcode);

        return addressRecords;

    }

    /**
     * Gets the AddressRecord for a building number at a postcode.
     * @param postcode containing postcode to query.
     * @param buildingNumber containing the building number at the postcode to query.
     * @return List<AddressRecord> List containing AddressRecord objects.
     */
    @Override
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber) {

        List<AddressRecord> addressRecords = addressRecordDAO.getAddressRecords(postcode, buildingNumber);

        return addressRecords;

    }

    /**
     * Gets the AddressRecord for a building by UDPRN.
     * @param UDPRN containing postcode to query.
     * @return List<AddressRecord> List containing AddressRecord objects.
     */
    @Override
    public List<AddressRecord> getAddressRecordsByUDPRN(String UDPRN) {

        List<AddressRecord> addressRecords = addressRecordDAO.getAddressRecordsByUDPRN(UDPRN);

        return addressRecords;

    }

    /**
     * Gets the AddressRecord for a building by UDPRN.
     * @param number containing postcode to query.
     * @return List<AddressRecord> List containing AddressRecord objects.
     */
    @Override
    public List<AddressRecord> getRandomAddressRecords(int number) {

        List<AddressRecord> addressRecords = addressRecordDAO.getRandomAddressRecords(number);

        return addressRecords;

    }

    /**
     * Validates a postcode.
     * @param postcode containing postcode to query.
     * @return List<ValidateRecord> List containing ValidateRecord objects.
     */
    @Override
    public List<ValidateRecord> validateAddressRecords(String postcode) {

        List<ValidateRecord> validateRecords = addressRecordDAO.validateAddressRecords(postcode);

        return validateRecords;

    }

    /**
     * Validates a postcode and building number
     * @param postcode containing postcode to query.
     * @param buildingNumber containing the building number at the postcode to validate.
     * @return List<ValidateRecord> List containing ValidateRecord objects.
     */
    @Override
    public List<ValidateRecord> validateAddressRecords(String postcode, String buildingNumber) {

        List<ValidateRecord> validateRecords = addressRecordDAO.validateAddressRecords(postcode, buildingNumber);

        return validateRecords;

    }

}
