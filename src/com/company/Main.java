package com.company;

import com.company.model.Airport;
import com.company.model.Graph;
import com.company.model.Route;
import com.company.model.State;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Airport> airports = getAirports();
        List<Route> routes = getRoutes();

        Graph graph = new Graph(airports,routes);

        DijkstrasSearch dijkstrasSearch = new DijkstrasSearch(graph, new HashSet<>(Arrays.asList()),new HashSet<>());

        State res = dijkstrasSearch.search(graph.iataToAirport("BEG"),graph.iataToAirport("AMS"));
        List<State> solution = res.getPath();
        double total =  0;
        for(int i=1;i<solution.size();i++){
            System.out.println(solution.get(i-1).getA().getCity() + " " + solution.get(i).getA().getCity() + " " + Math.round(solution.get(i).getA().distanceFromAirport(solution.get(i-1).getA())));
            total +=solution.get(i).getA().distanceFromAirport(solution.get(i-1).getA());
        }
        System.out.println("Ukupno "   + Math.round(total));
        /*HashMap<String, NodeMihajlov> nodes = new HashMap<>();
        for (Airport a: airports) {
            if(!nodes.containsKey(a.getIata())){
                nodes.put(a.getIata(),new NodeMihajlov(a));
            }
        }

        for (Route r:routes) {
            NodeMihajlov nodeToUpdate = nodes.get(r.getFromAirport());
            nodeToUpdate.addState(nodes.get(r.getToAirport()));
        }

        PathFinder pf = new PathFinder();
        List<NodeMihajlov> solution = pf.search(nodes.get("BEG"),nodes.get("AMS")).getPath();
        for(int i = 1;i < solution.size(); i++){
            System.out.println(solution.get(i-1).getAirport().getCity() + " " + solution.get(i).getAirport().getCity() + " " +solution.get(i).getCost());
        }
        System.out.println("Ukupno " + solution.get(solution.size()-1).getCost());

        for (NodeMihajlov n :nodes.values()) {
            System.out.println(n.toString());
        }*/
    }

    public static List<Route> getRoutes(){
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("C:\\Users\\Mihajlo\\IdeaProjects\\5danaNaJavi2017\\src\\routes.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray jo = (JSONArray) obj;
        List<Route> routeList = new ArrayList<>();
        for (Object o:jo) {
            JSONObject jsonObject = (JSONObject) o;
            Route r = new Route((String) jsonObject.get("fromAirport"),(String) jsonObject.get("toAirport"));
            routeList.add(r);
        }
        return routeList;
    }
    public static List<Airport> getAirports(){
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("C:\\Users\\Mihajlo\\IdeaProjects\\5danaNaJavi2017\\src\\airports.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray jo = (JSONArray) obj;
        List<Airport> airportList = new ArrayList<>();
        for (Object o:jo) {
            JSONObject jsonObject = (JSONObject) o;
            Airport r = new Airport((Long) jsonObject.get("airpotId"),(String) jsonObject.get("name"),
                    (String) jsonObject.get("city"),(String) jsonObject.get("country"),
                    (String) jsonObject.get("iata"),(Double) jsonObject.get("latitude"),(Double) jsonObject.get("longitude"));
            airportList.add(r);
        }
        return airportList;
    }
}
