/**
 * Created by andymccall on 19/01/2017.
 */

package software.postcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.postcode.api.model.Ping;

@RestController
@RequestMapping("/")
public class RESTController {

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody Ping ping() {

        Ping ping = new Ping();

        return ping;
    }

}


