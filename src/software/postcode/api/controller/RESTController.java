package software.postcode.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.postcode.api.model.*;
import software.postcode.api.service.AddressRecordService;

/**
 * The RESTController is the main controller where all the APIs are
 * called from.
 *
 * @author  Andy McCall
 * @version 0.2
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

        pingJsonResponse.setStatus(200);

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
    GenericJsonResponse getPostcode(@PathVariable String postcode) {
        logger.debug("Entering getPostcode()");

        GenericJsonResponse<AddressRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.getAddressRecords(postcode));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting getPostcode()");
        return genericJsonResponse;

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
    GenericJsonResponse getPostcode(@PathVariable String postcode, @PathVariable String buildingNumber) {
        logger.debug("Entering getPostcode()");

        GenericJsonResponse<AddressRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.getAddressRecords(postcode,buildingNumber));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting getPostcode()");
        return genericJsonResponse;

    }

    /**
     * Gets the AddressRecordJsonResponse for a building by UDPRN.
     * @param UDPRN containing postcode to query.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/udprn/{UDPRN}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getPostcodeByUDPRN(@PathVariable String UDPRN) {
        logger.debug("Entering getPostcodeByUDPRN()");

        GenericJsonResponse<AddressRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.getAddressRecordsByUDPRN(UDPRN));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting getPostcodeByUDPRN()");
        return genericJsonResponse;

    }

    /**
     * Gets the AddressRecordJsonResponse for a a number of random postcodes.
     * @param number the number of random postcodes to return.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/random/{number}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getRandomPostcode(@PathVariable String number) {
        logger.debug("Entering getRandomPostcode()");

        int quantityOfPostcodes=0;

        quantityOfPostcodes = Integer.parseInt(number);

        if (quantityOfPostcodes == 0) {
            quantityOfPostcodes++;
        }

        GenericJsonResponse<AddressRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.getRandomAddressRecords(quantityOfPostcodes));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting getRandomPostcode()");
        return genericJsonResponse;

    }

    /**
     * Gets the AddressRecordJsonResponse for a random postcode.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/random", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse getRandomPostcode() {
        logger.debug("Entering getRandomPostcode()");

        GenericJsonResponse<AddressRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.getRandomAddressRecords(1));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting getRandomPostcode()");
        return genericJsonResponse;

    }

    /**
     * Gets the GenericJsonResponse when valdiating a postcode.
     * @param postcode containing postcode to query.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/validate/{postcode}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse validatePostcode(@PathVariable String postcode) {
        logger.debug("Entering validatePostcode()");

        GenericJsonResponse<ValidateRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.validateAddressRecords(postcode));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting validatePostcode()");
        return genericJsonResponse;

    }

    /**
     * Gets the GenericJsonResponse when valdiating a postcode.
     * @param postcode containing postcode to query.
     * @return AddressRecordJsonResponse.
     */
    @RequestMapping(value = "/validate/{postcode}/{buildingNumber}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    public @ResponseBody
    GenericJsonResponse validatePostcode(@PathVariable String postcode, @PathVariable String buildingNumber) {
        logger.debug("Entering validatePostcode()");

        GenericJsonResponse<ValidateRecord> genericJsonResponse = new GenericJsonResponse<>();

        genericJsonResponse.setResult(addressRecordService.validateAddressRecords(postcode,buildingNumber));

        genericJsonResponse.setStatus(200);

        logger.debug("Exiting validatePostcode()");
        return genericJsonResponse;

    }

}


