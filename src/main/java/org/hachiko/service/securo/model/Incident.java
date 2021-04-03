package org.hachiko.service.securo.model;

import javax.persistence.*;

@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private Geofence geofence;

    @Column(name = "country")
    private String country;

    @Column(name = "comment", nullable = false)
    private String comment;

    public int getId() {
        return id;
    }

    public Geofence getGeofence() {
        return geofence;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGeofence(Geofence geofence) {
        this.geofence = geofence;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("id=%d, lat=%f, lng=%f, radius=%f, comment=%s", id, geofence.getLat(), geofence.getLng(), geofence.getRadius(), comment);
    }
}
