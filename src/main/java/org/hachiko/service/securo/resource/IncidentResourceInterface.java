package org.hachiko.service.securo.resource;

import org.hachiko.service.securo.model.Incident;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IncidentResourceInterface {
    Incident incidentGet(@PathVariable(name = "id") int id);

    List incidentsGet(@RequestParam(name = "country", required = false) String country);

    ResponseEntity<String> incidentPost(@RequestBody Incident incident);

    void incidentPut(@RequestBody Incident incident);

    ResponseEntity<String> incidentDelete(@PathVariable(name = "id") int id);
}
