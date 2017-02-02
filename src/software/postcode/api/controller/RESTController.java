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

/**
 * The RESTController is the main controller where all the APIs are
 * called from.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-29
 */
@RestController
@RequestMapping("/")
public class RESTController {

    private static final Logger logger =
            LoggerFactory.getLogger(RESTController.class);

    AddressRecordService addressRecordService;

    /**
     * Sets the AddressRecordService for the controller.
     */
    @Autowired
    public void setProductService(AddressRecordService addressRecordService) {
        logger.debug("Entering setProductService()");

        this.addressRecordService = addressRecordService;

        logger.debug("Exiting setProductService()");
    }

    /**
     * Gets the PingJsonResponse for the controller.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    PingJsonResponse getPing() {
        logger.debug("Entering getPing()");

        Ping ping = new Ping();

        PingJsonResponse pingJsonResponse = new PingJsonResponse();
        pingJsonResponse.setResult(ping);

        if (pingJsonResponse.getResult() != null) {
            pingJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getPing()");
        return (pingJsonResponse);
    }

    /**
     * Gets the AddressRecordJsonResponse for a building by postcode.
     * @param postcode containing postcode to query.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/postcode/{postcode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
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

    /***
     * Gets the AddressRecordJsonResponse for a list of postcodes.
     * @param
     * @return AddressRecordJsonResponse
     */
    @RequestMapping(value = "/postcode/", method = RequestMethod.POST)
    public @ResponseBody
    AddressRecordJsonResponse getBulkPostcode() {
        logger.debug("Entering getBulkPostcode()");

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        logger.debug("Exiting getBulkPostcode()");
        return addressRecordJsonResponse;
    }

    /**
     * Gets the AddressRecordJsonResponse for a building by postcode filtered by
     * building number.
     * @param postcode containing postcode to query.
     * @param buildingNumber containing building number to filter by.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/postcode/{postcode}/{buildingNumber}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
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

    /**
     * Gets the AddressRecordJsonResponse for a building by UDPRN.
     * @param UDPRN containing postcode to query.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/udprn/{UDPRN}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    AddressRecordJsonResponse getPostcodeByUDPRN(@PathVariable String UDPRN) {
        logger.debug("Entering getPostcodeByUDPRN()");

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getAddressRecordsByUDPRN(UDPRN));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getPostcodeByUDPRN()");
        return addressRecordJsonResponse;

    }

    /**
     * Gets the AddressRecordJsonResponse for a building by postcode.
     * @return AddressRecordJsonResponse.   (@RequestParam(value = "i", required=false) Integer i)
     */
    @RequestMapping(value = "/random/{number}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    AddressRecordJsonResponse getRandomPostcode(@PathVariable String number) {
        logger.debug("Entering getRandomPostcode()");

        int quantityOfPostcodes=0;

        quantityOfPostcodes = Integer.parseInt(number);

        if (quantityOfPostcodes == 0) {
            quantityOfPostcodes++;
        }

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getRandomAddressRecords(quantityOfPostcodes));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getRandomPostcode()");
        return addressRecordJsonResponse;

    }

    /**
     * Gets the AddressRecordJsonResponse for a building by postcode.
     * @return AddressRecordJsonResponse.   (@RequestParam(value = "i", required=false) Integer i)
     */
    @RequestMapping(value = "/random", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    AddressRecordJsonResponse getRandomPostcode() {
        logger.debug("Entering getRandomPostcode()");

        AddressRecordJsonResponse<AddressRecord> addressRecordJsonResponse = new AddressRecordJsonResponse<>();

        addressRecordJsonResponse.setResult(addressRecordService.getRandomAddressRecords(1));
        if (addressRecordJsonResponse.getResult().isEmpty()) {
            addressRecordJsonResponse.setStatus(404);
        } else {
            addressRecordJsonResponse.setStatus(200);
        }

        logger.debug("Exiting getRandomPostcode()");
        return addressRecordJsonResponse;

    }


}


