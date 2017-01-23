/**
 * Created by andymccall on 19/01/2017.
 */

package software.postcode.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger =
            LoggerFactory.getLogger(RESTController.class);

    AddressRecordService addressRecordService;

    @Autowired
    public void setProductService(AddressRecordService addressRecordService) {
        logger.debug("Entering setProductService()");

        this.addressRecordService = addressRecordService;

        logger.debug("Exiting setProductService()");
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody
    PingJsonResponse getPing() {
        logger.debug("Entering getPing()");

        Ping ping = new Ping();

        PingJsonResponse pingJsonResponse = new PingJsonResponse();
        pingJsonResponse.setResult(ping);

        if (pingJsonResponse.getResult() == null) {
            logger.debug("JsonResponse result is null, ping does not exist");
            pingJsonResponse.setStatus(500);
            pingJsonResponse.setError("Something catastrophic went wrong!");
        } else {
            pingJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getPing()");
        return (pingJsonResponse);
    }

    @RequestMapping(value = "/postcode/{postcode}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody
    AddressRecordJsonResponse getPostcode(@PathVariable String postcode) {
        logger.debug("Entering getPostcode()");

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getAddressRecords(postcode));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getPostcode()");
        return addressRecordJsonResponse;

    }

    @RequestMapping(value = "/postcode/{postcode}/{buildingNumber}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody
    AddressRecordJsonResponse getPostcode(@PathVariable String postcode, @PathVariable String buildingNumber) {
        logger.debug("Entering getPostcode()");

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getAddressRecords(postcode,buildingNumber));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getPostcode()");
        return addressRecordJsonResponse;

    }

}


