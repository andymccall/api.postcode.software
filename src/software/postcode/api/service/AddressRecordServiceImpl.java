package software.postcode.api.service;

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

}
