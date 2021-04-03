package org.hachiko.service.securo.dao;

import org.hachiko.service.securo.model.Incident;

import java.util.List;

public interface IncidentDAO {
    Incident getIncident(int id);

    List getIncidents();

    List getIncidentsByCountry(String country);

    long saveIncident(Incident incident);

    void deleteIncident(int id);
}
