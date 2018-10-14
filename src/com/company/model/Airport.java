package com.company.model;

import uk.me.jstott.jcoord.LatLng;

public class Airport {
    Long airpotId;
    String name;
    String city;
    String country;
    String iata;
    Double latitude;
    Double longitude;

    public Airport(Long airpotId, String name, String city, String country, String iata, Double latitude, Double longitude) {
        this.airpotId = airpotId;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iata = iata;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getAirpotId() {
        return airpotId;
    }

    public void setAirpotId(Long airpotId) {
        this.airpotId = airpotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double distanceFromAirport(Airport airport) {
        LatLng lld1 = new LatLng(airport.getLatitude(),airport.getLongitude());
        LatLng lld2 = new LatLng(this.getLatitude(),this.getLongitude());
        Double distance = lld1.distance(lld2);
        return distance;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airpotId=" + airpotId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iata='" + iata + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
