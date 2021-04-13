package org.hachiko.service.securo.dto;

import org.hachiko.service.securo.model.Geofence;
import org.hachiko.service.securo.model.Incident;

public class IncidentDTO {
    private int id;
    private GeofenceDTO geofence;
    private String country;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GeofenceDTO getGeofence() {
        return geofence;
    }

    public void setGeofence(GeofenceDTO geofence) {
        this.geofence = geofence;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Incident getIncidentPOJO() {
        Incident incident = new Incident();
        incident.setId(getId());
        incident.setCountry(getCountry());
        incident.setComment(getComment());

        Geofence geofence = getGeofence().getGeofencePOJO();

        incident.setGeofence(geofence);

        return incident;
    }
}
