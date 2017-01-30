package software.postcode.api.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import software.postcode.api.model.AddressRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * The MongoConfiguration class is a class that implements the
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


}
