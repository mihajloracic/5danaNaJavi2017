package com.company;

import com.company.model.NodeMihajlov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PathFinder {

    public NodeMihajlov search(NodeMihajlov startNode, NodeMihajlov endNode){
        List<NodeMihajlov> processedNodes = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        processedNodes.add(startNode);
        while (processedNodes.size() > 0){
            NodeMihajlov processed = getBeast(processedNodes);

            if(!visited.contains(processed.getAirport().getIata())){
                if(processed.getAirport().getIata() == endNode.getAirport().getIata()){
                    return processed;
                }
            }
            visited.add(processed.getAirport().getIata());
            for (NodeMihajlov n:processed.getNextState()) {
                processedNodes.add(n);
            }
            processedNodes.remove(processed);
        }
        return null;
    }

    public double heuristicFunction(NodeMihajlov n){
        return 0;
    }

    public NodeMihajlov getBeast(List<NodeMihajlov> nodes){
        NodeMihajlov retNode = null;
        double min = Double.MAX_VALUE;
        for (NodeMihajlov n:nodes) {
            double h = n.getCost();
            if(h<min){
                min = h;
                retNode = n;
            }
        }
        return  retNode;
    }

}
