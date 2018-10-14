package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class State {

    private Airport a;
    private State parent;
    private double cost;

    public State(Airport a) {
        this.a = a;
        this.cost = 0;
        this.parent = null;
    }
    public State() {

    }

    public State newState(Airport airportTo){
        State ret = new State();
        ret.setA(airportTo);
        ret.setParent(this);
        ret.setCost(this.cost + a.distanceFromAirport(airportTo));
        return ret;
    }

    public List<State> possibleNextStates(Graph g){

        List<State> ret = new ArrayList<>();
        for(Airport a : g.findConnections(a)){
            ret.add(newState(a));
        }
        return ret;
    }

    public List<State> getPath(){
        List<State> path = new ArrayList<>();
        State tt = this;
        while(tt != null){
            path.add(0,tt);
            tt = tt.getParent();
        }
        return path;
    }


    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public Airport getA() {
        return a;
    }

    public void setA(Airport a) {
        this.a = a;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
