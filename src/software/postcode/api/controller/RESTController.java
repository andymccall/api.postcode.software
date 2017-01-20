/**
 * Created by andymccall on 19/01/2017.
 */

package software.postcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.Ping;
import software.postcode.api.service.AddressRecordService;

import java.util.List;

@RestController
@RequestMapping("/")
public class RESTController {

    AddressRecordService addressRecordService;

    @Autowired
    public void setProductService(AddressRecordService addressRecordService) {
        this.addressRecordService = addressRecordService;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody Ping ping() {

        Ping ping = new Ping();

        return ping;
    }

    @RequestMapping(value = "/postcode/{postcode}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody List<AddressRecord> getPostcode(@PathVariable String postcode) {

        List<AddressRecord> addressRecords = addressRecordService.getAddressRecords(postcode);

        return addressRecords;

    }


    }


