/**
 * Created by andymccall on 19/01/2017.
 */

package software.postcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.postcode.api.model.AddressRecord;
import software.postcode.api.model.AddressRecordJsonResponse;
import software.postcode.api.model.Ping;
import software.postcode.api.model.PingJsonResponse;
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
    public @ResponseBody
    PingJsonResponse getPing() {

        Ping ping = new Ping();

        PingJsonResponse pingJsonResponse = new PingJsonResponse();
        pingJsonResponse.setResult(ping);

        if (pingJsonResponse.getResult() == null) {
            pingJsonResponse.setStatus(500);
            pingJsonResponse.setError("Something catastrophic went wrong!");
        } else {
            pingJsonResponse.setStatus(200);
        }

        return (pingJsonResponse);
    }

    @RequestMapping(value = "/postcode/{postcode}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody
    AddressRecordJsonResponse getPostcode(@PathVariable String postcode) {

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getAddressRecords(postcode));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        return addressRecordJsonResponse;

    }

    @RequestMapping(value = "/postcode/{postcode}/{buildingNumber}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody
    AddressRecordJsonResponse getPostcode(@PathVariable String postcode, @PathVariable String buildingNumber) {

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getAddressRecords(postcode,buildingNumber));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        return addressRecordJsonResponse;

    }

}


