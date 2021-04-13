package org.hachiko.service.securo.resource;

import org.apache.log4j.Logger;
import org.hachiko.service.securo.dao.IncidentDAOImpl;
import org.hachiko.service.securo.dto.IncidentDTO;
import org.hachiko.service.securo.model.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/incident")
public class IncidentResource implements IncidentResourceInterface {
    static Logger logger = Logger.getLogger(IncidentResource.class.getName());

    @Autowired
    private IncidentDAOImpl incidentDAO;

    @Override
    public Incident incidentGet(@PathVariable(name = "id") int id) {
        logger.info(String.format("%s", "Calling get incident"));

        Incident incident = incidentDAO.getIncident(id);

        if (incident == null) {
            logger.info(String.format("Incident by id %s not found", id));
            incident = new Incident();
        } else {
            logger.info(String.format("%s", incident));
        }

        return incident;
    }

    @Override
    public List incidentsGet(@RequestParam(name = "country", required = false) String country) {
        logger.info(String.format("%s", "Calling get incidents"));

        List incidents;

        if (country == null) {
            incidents = incidentDAO.getIncidents();
        } else {
            incidents = incidentDAO.getIncidentsByCountry(country);
        }

        if (incidents.isEmpty()) {
            logger.info(String.format("%s", "Incidents not found"));
        } else {
            logger.info(String.format("Incidents found : %d", incidents.size()));
        }

        return incidents;
    }

    @Override
    public ResponseEntity<String> incidentPost(@RequestBody IncidentDTO incident) {
        logger.info(String.format("%s", "Calling post incident"));

        incidentDAO.saveIncident(incident.getIncidentPOJO());

        return new ResponseEntity<>("Incident saved successfully", HttpStatus.OK);
    }

    @Override
    public void incidentPut(@RequestBody IncidentDTO incident) {
        logger.info(String.format("%s", "Calling put incident"));
    }

    @Override
    public ResponseEntity<String> incidentDelete(@PathVariable(name = "id") int id) {
        logger.info(String.format("%s", "Calling delete incident"));

        incidentDAO.deleteIncident(id);

        return new ResponseEntity<>("Incident deleted successfully", HttpStatus.OK);
    }
}
