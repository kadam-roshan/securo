package org.hachiko.service.securo.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hachiko.service.securo.model.Health;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(path = "/swagger-apis/swagger.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getApiDoc() {
        logger.info(String.format("%s", "Calling api docs"));

        Resource resource = new ClassPathResource("/swagger-apis/swagger.json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(resource.getInputStream(), Object.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
