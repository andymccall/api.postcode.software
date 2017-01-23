package software.postcode.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.postcode.api.dao.AddressRecordDAO;
import software.postcode.api.model.AddressRecord;

import java.util.List;

/**
 * Created by andymccall on 20/01/2017.
 */
@Service("addressRecordService")
public class AddressRecordServiceImpl implements AddressRecordService {

    private static final Logger logger =
            LoggerFactory.getLogger(AddressRecordServiceImpl.class);

    @Autowired
    private AddressRecordDAO addressRecordDAO;

    public void setAddressRecordDAO(AddressRecordDAO addressRecordDAO) {

        this.addressRecordDAO = addressRecordDAO;

    }

    @Override
    public List<AddressRecord> getAddressRecords(String postcode) {

        List<AddressRecord> addressRecords = addressRecordDAO.getAddressRecords(postcode);

        return addressRecords;

    }

    @Override
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber) {

        List<AddressRecord> addressRecords = addressRecordDAO.getAddressRecords(postcode, buildingNumber);

        return addressRecords;

    }

}
