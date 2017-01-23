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

    private AddressRecord addressPopulator(String[] line) {

        AddressRecord addressRecord = new AddressRecord();

        addressRecord.setPostcode(line[0]);
        addressRecord.setPostTown(line[1]);
        addressRecord.setDependantLocality(line[2]);
        addressRecord.setDoubleDependentLocality(line[3]);
        addressRecord.setThoroughfareAndDescriptor(line[4]);
        addressRecord.setDependentThoroughfareAndDescriptor(line[5]);
        addressRecord.setBuildingNumber(line[6]);
        addressRecord.setBuildingName(line[7]);
        addressRecord.setSubBuildingName(line[8]);
        addressRecord.setPOBox(line[9]);
        addressRecord.setDepartmentName(line[10]);
        addressRecord.setOrganisationName(line[11]);
        addressRecord.setUDPRN(line[12]);
        addressRecord.setPostcodeType(line[13].charAt(0));
        addressRecord.setSUOrganisationIndicator(line[14].charAt(0));
        addressRecord.setDeliveryPointSuffix(line[15]);

        return addressRecord;

    }

    @Override
    public List<AddressRecord> getAddressRecords(String postcode){

        //String pafFile = "/opt/api.postcode.software/CSV_PAF.csv";
        String pafFile = "/Users/andymccall/Downloads/csv_paf/CSV_PAF.csv";

        List<AddressRecord> addressList = new ArrayList<AddressRecord>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(pafFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].replaceAll("\\s+","").toLowerCase().equals(postcode.toLowerCase())) {
                    addressList.add(addressPopulator(line));
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

        List<AddressRecord> addressList = new ArrayList<AddressRecord>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(pafFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].replaceAll("\\s+","").toLowerCase().equals(postcode.toLowerCase())) {
                    if (line[6].toLowerCase().equals(buildingNumber.toLowerCase())) {
                        addressList.add(addressPopulator(line));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return addressList;
    }


}
