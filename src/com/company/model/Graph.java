package com.company.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<Airport, List<Airport>> connections;

    HashMap<String, Airport> iataToAirportMap = new HashMap<>();

    public Graph(List<Airport> airports,List<Route> routes) {
        connections = new HashMap<>();

        for(Airport a: airports){
            connections.put(a,new ArrayList<>());
            iataToAirportMap.put(a.getIata(),a);
        }

        for(Route r: routes){
            Airport from = iataToAirportMap.get(r.getFromAirport());
            Airport to = iataToAirportMap.get(r.getToAirport());
            connections.get(from).add(to);
        }
    }

    public List<Airport> findConnections(Airport a){
        return connections.get(a);
    }

    public Airport iataToAirport(String iata){
        return iataToAirportMap.get(iata);
    }

}
