package org.hachiko.service.securo.resource;

import org.hachiko.service.securo.dto.IncidentDTO;
import org.hachiko.service.securo.model.Incident;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IncidentResourceInterface {
    @GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Incident incidentGet(@PathVariable(name = "id") int id);

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List incidentsGet(@RequestParam(name = "country", required = false) String country);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> incidentPost(@RequestBody IncidentDTO incident);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void incidentPut(@RequestBody IncidentDTO incident);

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> incidentDelete(@PathVariable(name = "id") int id);
}
