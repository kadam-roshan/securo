package org.hachiko.service.securo.dto;

import org.hachiko.service.securo.model.Geofence;

public class GeofenceDTO {
    private Double lat;
    private Double lng;
    private Double radius;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Geofence getGeofencePOJO() {
        Geofence geofence = new Geofence();
        geofence.setLng(getLng());
        geofence.setLat(getLat());
        geofence.setRadius(getRadius());

        return geofence;
    }
}
