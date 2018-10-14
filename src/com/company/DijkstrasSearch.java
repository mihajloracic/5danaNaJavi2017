package com.company;

import com.company.model.Airport;
import com.company.model.Graph;
import com.company.model.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DijkstrasSearch {

    Graph graph;
    Set<Airport> forbiden;
    Set<Airport> prefered;

    public DijkstrasSearch(Graph graph, Set<Airport> forbiden, Set<Airport> prefered) {
        this.graph = graph;
        this.forbiden = forbiden;
        this.prefered = prefered;
    }

    public State search(Airport startAirport, Airport endAirport){
        List<State> stanjaZaObradu = new ArrayList<>();
        Set<State> predjeniPut = new HashSet<>();
        stanjaZaObradu.add(new State(startAirport));
        while (stanjaZaObradu.size() > 0){
            State naObradi = getBest(stanjaZaObradu);
            if(!predjeniPut.contains(naObradi)){
                if(naObradi.getA().getIata().equals(endAirport.getIata())){
                    return naObradi;
                }
                predjeniPut.add(naObradi);
                for (State s : naObradi.possibleNextStates(graph)){
                    stanjaZaObradu.add(s);
                }
            }
            stanjaZaObradu.remove(naObradi);
        }
        return null;
    }

    private State getBest(List<State> stanjaZaObradu) {
        State rez = null;
        double min = Double.MAX_VALUE;

        for (State s : stanjaZaObradu)
        {
            double h = s.getCost() + isForbided(s.getA()) + isPrefered(s.getA());
            if (h < min)
            {
                min = h;
                rez = s;
            }
        }
        return rez;
    }

    private double isForbided(Airport a) {
        return forbiden.contains(a) ? 1000 : 0;
    }

    private double isPrefered(Airport a) {
        return prefered.contains(a) ? -1000 : 0;
    }

}
