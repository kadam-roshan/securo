package org.hachiko.service.securo.resource;

import org.hachiko.service.securo.model.Health;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

public interface HomeResourceInterface {
    @GetMapping(path = "/health.do", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Health health();
}
