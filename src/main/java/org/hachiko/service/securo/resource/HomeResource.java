package org.hachiko.service.securo.resource;

import org.hachiko.service.securo.model.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
public class HomeResource implements HomeResourceInterface {
    static Logger logger = Logger.getLogger(HomeResource.class.getName());

    @Autowired
    Health health;

    @Override
    public Health health() {
        logger.info(String.format("%s", "Calling health resource"));
        return health;
    }
}
