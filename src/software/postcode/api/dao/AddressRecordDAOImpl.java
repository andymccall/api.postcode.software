package software.postcode.api.dao;

import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.ValidateRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The AddressRecordDAOImpl class is a class that implements the
 * AddressRecordDAO to store and retrieve data from the
 * mongodb.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-29
 */
@Repository("addressRecordDAO")
public class AddressRecordDAOImpl implements AddressRecordDAO {

    private static final Logger logger =
            LoggerFactory.getLogger(AddressRecordDAOImpl.class);

    private MongoOperations mongoOperations;
    private static final String ADDRESS_RECORD_COLLECTION = "AddressRecord";

    /**
     * Constructor.
     * @param mongoOperations containing the MongoOperations
     *                        variable.
     */
    @Autowired
    public AddressRecordDAOImpl(MongoOperations mongoOperations){

        this.mongoOperations=mongoOperations;
    }

    /**
     * Gets a list of AddressRecords for a given postcode.
     * @param postcode containing postcode to search for
     */
    @Override
    public List<AddressRecord> getAddressRecords(String postcode){

        Query query = new Query(Criteria.where("internalPostcode").is(postcode));

        List<AddressRecord> addressList = mongoOperations.find(query, AddressRecord.class, ADDRESS_RECORD_COLLECTION);

        return addressList;

    }

    /**
     * Gets a list of AddressRecords for a given postcode and building number.
     * @param postcode containing postcode to search for
     * @param buildingNumber to filter on
     */
    @Override
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber){

        Query query = new Query(Criteria.where("internalPostcode").is(postcode).and("buildingNumber").is(buildingNumber));

        List<AddressRecord> addressList = mongoOperations.find(query, AddressRecord.class, ADDRESS_RECORD_COLLECTION);

        return addressList;
    }

    /**
     * Gets a list of AddressRecords for a given UDPRN.
     * @param UDPRN containing UDPRN to search for
     */
    @Override
    public List<AddressRecord> getAddressRecordsByUDPRN(String UDPRN){

        Query query = new Query(Criteria.where("_id").is(UDPRN));
        AddressRecord addressRecord = mongoOperations.findOne(query, AddressRecord.class, ADDRESS_RECORD_COLLECTION);

        List<AddressRecord> addressList = new ArrayList<>();
        addressList.add(addressRecord);

        return addressList;
    }

    @Override
    public List<AddressRecord> getRandomAddressRecords(int number){

        Query query = new Query();
        long count = mongoOperations.count(query, AddressRecord.class, ADDRESS_RECORD_COLLECTION);

        List<AddressRecord> addressList = new ArrayList<>();

        Random random = new Random();

        for (int i=0; i<number; i++) {

            long randomNumber = count + ((long) (random.nextDouble() * (0 - count)));

            query = new Query(Criteria.where("internalSequence").is(randomNumber));
            AddressRecord addressRecord = mongoOperations.findOne(query, AddressRecord.class, ADDRESS_RECORD_COLLECTION);

            addressList.add(addressRecord);
        }

        return addressList;

    }

    /**
     * Gets a list of AddressRecords for a given postcode.
     * @param postcode containing postcode to search for
     */
    @Override
    public List<ValidateRecord> validateAddressRecords(String postcode){

        ValidateRecord validateRecord = new ValidateRecord();

        Query query = new Query(Criteria.where("internalPostcode").is(postcode));

        List<AddressRecord> addressList = mongoOperations.find(query, AddressRecord.class, ADDRESS_RECORD_COLLECTION);

        if (addressList.size() > 1) {
            validateRecord.setPostcode(postcode);
            validateRecord.setValid(true);
        } else {
            validateRecord.setPostcode(postcode);
            validateRecord.setValid(false);
        }

        List<ValidateRecord> validateList = new ArrayList<>();

        validateList.add(validateRecord);

        return validateList;

    }


}
