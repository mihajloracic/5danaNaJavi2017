package com.company;

import com.company.model.Airport;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {
    private static final double EPS = 1e-6;
    private int n;
    private HashMap<Node,Double> dist;
    private Integer[] prev;
    private List<List<Edge>> graph;
    //dist[xyz] =>  dist.get(airport.getId())
    private HashMap<Airport,Node> airportToNode;

    public Dijkstras(List<Airport> airports){
        dist = new HashMap<>();
        airportToNode = new HashMap<>();
        for (Airport a: airports) {
            Node n = new Node(a,0);
            dist.put(n, Double.POSITIVE_INFINITY);
            airportToNode.put(a,n);
        }
    }

    public double findPath(Airport startAiport, Airport endAirport){
        dist.put(airportToNode.get(startAiport),0.00);
        // Keep a priority queue of the next most promising node to visit.
        PriorityQueue<Node> pq = new PriorityQueue<>(2*n, comparator);



        return 0;

    }
    private Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node node1, Node node2) {
            if (Math.abs(node1.value-node2.value) < EPS) return 0;
            return (node1.value - node2.value) > 0 ? +1 : -1;
        }
    };

}
