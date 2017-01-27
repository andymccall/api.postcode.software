package software.postcode.api.dao;

import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import software.postcode.api.model.AddressRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andymccall on 20/01/2017.
 */
@Repository("addressRecordDAO")
public class AddressRecordDAOImpl implements AddressRecordDAO {

    private static final Logger logger =
            LoggerFactory.getLogger(AddressRecordDAOImpl.class);

    @Override
    public List<AddressRecord> getAddressRecords(String postcode){

        String pafFile = "/opt/api.postcode.software/CSV_PAF.csv";
        //String pafFile = "/Users/andymccall/Downloads/csv_paf/CSV_PAF.csv";

        List<AddressRecord> addressList = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(pafFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].replaceAll("\\s+","").toLowerCase().equals(postcode.toLowerCase())) {
                    AddressRecord addressRecord = new AddressRecord();
                    addressList.add(addressRecord.populateAddressRecord(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return addressList;
    }

    @Override
    public List<AddressRecord> getAddressRecords(String postcode, String buildingNumber){

        //String pafFile = "/opt/api.postcode.software/CSV_PAF.csv";
        String pafFile = "/Users/andymccall/Downloads/csv_paf/CSV_PAF.csv";

        List<AddressRecord> addressList = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(pafFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].replaceAll("\\s+","").toLowerCase().equals(postcode.toLowerCase())) {
                    if (line[6].toLowerCase().equals(buildingNumber.toLowerCase())) {
                        AddressRecord addressRecord = new AddressRecord();
                        addressList.add(addressRecord.populateAddressRecord(line));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return addressList;
    }


}
