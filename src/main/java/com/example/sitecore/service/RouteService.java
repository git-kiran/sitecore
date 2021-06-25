package com.example.sitecore.service;

import com.example.sitecore.domain.dto.Edge;
import com.example.sitecore.domain.dto.Graph;
import com.example.sitecore.domain.dto.Route;
import com.example.sitecore.domain.dto.Vertex;
import com.example.sitecore.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    private List<Vertex> nodes;
    private List<Edge> edges;
    private String[] tempString;
    private Set<String> aSet = new HashSet<String>();
    private int sum = 0;

    public void processgraph(String departure, String arrival) {
        List<String> repo = routeRepository.findAllCodes();
        for (int i = 0; i < repo.size(); i++) {
            tempString = repo.get(i).split(",");
            aSet.add(tempString[0]);
            aSet.add(tempString[1]);
        }
        repo = new ArrayList<>(aSet);
        if (!repo.contains(departure) || !repo.contains(arrival)) {
            throw new RuntimeException("Either/both locations are not served yet");
        }

        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < repo.size(); i++) {
            Vertex location = new Vertex(repo.get(i), repo.get(i));
            nodes.add(location);
        }

        //System.out.println("repos = " + repo);
        List<Route> allRoutes = routeRepository.findAll();
        for (int i = 0; i < allRoutes.size(); i++) {
            //System.out.println("values are = " + repo.indexOf(allRoutes.get(i).getDeparture()) + " " + repo.indexOf(allRoutes.get(i).getArrival()) + " "  + allRoutes.get(i).getDistance());
            addToEdge("Edge_" + i, repo.indexOf(allRoutes.get(i).getDeparture()), repo.indexOf(allRoutes.get(i).getArrival()), allRoutes.get(i).getDistance());
        }

        Graph graph = new Graph(nodes, edges);
        RouteImplementation routeImplementation = new RouteImplementation(graph);
        routeImplementation.execute(nodes.get(repo.indexOf(departure)));
        LinkedList<Vertex> path = routeImplementation.getPath(nodes.get(repo.indexOf(arrival)));

        if (path == null) {
            throw new RuntimeException("No route found");
        }
        System.out.println("Shortest Path to choose: ");
        for (Vertex vertex : path) {
            System.out.println(vertex.getName());
        }

        for (int i = 0; i < path.size() - 1; i++) {
            sum += routeImplementation.getDistance(path.get(i), path.get(i + 1));
        }

        System.out.println("Time: \n\n" + sum);
        sum = 0;
    }

    private void addToEdge(String id, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(id, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
