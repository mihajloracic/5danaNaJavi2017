package com.company;

import com.company.model.Airport;

public class Edge {
    Airport from;
    Airport to;
    double cost;

    public Edge(Airport from, Airport to) {
        this.from = from;
        this.to = to;
        this.cost = from.distanceFromAirport(to);
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getTo() {
        return to;
    }

    public void setTo(Airport to) {
        this.to = to;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", cost=" + cost +
                '}';
    }
}
