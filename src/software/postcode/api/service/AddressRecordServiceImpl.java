package software.postcode.api.service;

import org.springframework.stereotype.Service;
import software.postcode.api.model.AddressRecord;

/**
 * Created by andymccall on 20/01/2017.
 */
@Service("addressRecordService")
public class AddressRecordServiceImpl implements AddressRecordService {

    @Override
    public AddressRecord getAddressRecord(String postcode) {

        AddressRecord addressRecord = new AddressRecord();

        return addressRecord;

    }

}
