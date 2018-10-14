package com.company.model;

import uk.me.jstott.jcoord.LatLng;

import java.util.ArrayList;
import java.util.List;

public class NodeMihajlov {
    Airport airport;
    List<NodeMihajlov> nextState;
    NodeMihajlov parent;
    double cost;

    public NodeMihajlov(Airport airport) {
        this.airport = airport;
        nextState = new ArrayList<>();
        parent = null;
        cost = 0;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public List<NodeMihajlov> getNextState() {
        return nextState;
    }

    public void setNextState(List<NodeMihajlov> nextState) {
        this.nextState = nextState;
    }

    public NodeMihajlov getParent() {
        return parent;
    }

    public void setParent(NodeMihajlov parent) {
        this.parent = parent;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
            this.cost = cost;
    }

    public List<NodeMihajlov> getPath(){
        List<NodeMihajlov> path = new ArrayList<>();
        NodeMihajlov tt = this;
        while(tt != null){
            path.add(0,tt);
            tt = tt.getParent();
        }
        return path;
    }

    @Override
    public String toString() {
        String connections = "";
        for (NodeMihajlov n: nextState) {
            connections += n.getAirport().getCity() + ",";
        }
        return this.getAirport().getAirpotId() + " " + getAirport().getName() + " connections: " + connections;
    }

    public void addState(NodeMihajlov node) {
        this.nextState.add(node);
        node.setParent(this);
        node.setCost(cost + distanceBetweenNodes(this,node));
    }

    private double distanceBetweenNodes(NodeMihajlov node, NodeMihajlov node1) {
        LatLng lld1 = new LatLng(node.getAirport().getLatitude(),node.getAirport().getLongitude());
        LatLng lld2 = new LatLng(node1.getAirport().getLatitude(),node1.getAirport().getLongitude());
        Double distance = lld1.distance(lld2);
        return distance;
    }
}
