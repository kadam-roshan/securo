package org.hachiko.service.securo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Geofence {
    @Column(name = "lat", nullable = false)
    private Double lat;

    @Column(name = "lng", nullable = false)
    private Double lng;

    @Column(name = "radius", nullable = false)
    private Double radius;

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public Double getRadius() {
        return radius;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
