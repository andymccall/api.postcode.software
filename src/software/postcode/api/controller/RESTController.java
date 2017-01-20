/**
 * Created by andymccall on 19/01/2017.
 */

package software.postcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.Ping;
import software.postcode.api.service.AddressRecordService;

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
    public @ResponseBody AddressRecord getPostcode(@PathVariable String postcode) {

        AddressRecord addressRecord;
        addressRecord = addressRecordService.getAddressRecord(postcode);

        System.out.println(addressRecord);

        return addressRecord;

    }


    }


