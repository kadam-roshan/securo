package org.hachiko.service.securo.resource;

import org.hachiko.service.securo.model.Health;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
public class HomeResource implements HomeResourceInterface {
    static Logger logger = Logger.getLogger(HomeResource.class.getName());

    @RequestMapping(path = "/health.do", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Health health() {
        logger.info(String.format("%s", "Calling health resource"));
        return new Health("OK");
    }
}
