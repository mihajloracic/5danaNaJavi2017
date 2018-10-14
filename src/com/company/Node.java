package com.company;

import com.company.model.Airport;

public class Node {
    Airport airport;
    double value;

    public Node(Airport airport, double value) {
        this.airport = airport;
        this.value = value;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "airport=" + airport +
                ", value=" + value +
                '}';
    }
}
