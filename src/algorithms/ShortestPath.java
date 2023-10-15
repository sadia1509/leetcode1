package algorithms;

import dataStructure.nonLinear.Graph;
import java.util.Map.Entry;
import java.util.*;

public class ShortestPath {
    Map<Object, List<Object>> graph;
    GraphCreation gc = new GraphCreation();

    public void makeNegativeCyclicGraph() {
        graph = new HashMap<>();
        gc.addEdge(1, 2, 4);
        gc.addEdge(1, 4, 5);
        gc.addEdge(3, 2, -10);
        gc.addEdge(4, 3, 3);
        gc.addEdge(2, 4, 5);

//        gc.addEdge(1, 2, 10);
//        gc.addEdge(2, 3, 20);
//        gc.addEdge(3, 2, -30);
    }

    public void makeCyclicGraph() {
        graph = new HashMap<>();
        //{1,2,3,4,5,6}
        gc.addEdge(1, 2, 50);
        gc.addEdge(1, 4, 10);
        gc.addEdge(1, 3, 45);
        gc.addEdge(2,3, 10);
        gc.addEdge(2,4, 15);
        gc.addEdge(3,5, 30);
        gc.addEdge(4,1, 10);
        gc.addEdge(4,5, 15);
        gc.addEdge(5,2, 20);
        gc.addEdge(5,2, 20);
        gc.addEdge(5,3, 35);
        gc.addEdge(6,5, 3);

//        gc.addEdge(1, 2, 20);
//        gc.addEdge(2, 3, 10);
//        gc.addEdge(1, 3, 4);
    }

    public Map<Object, List<Edge>> getGraph() {
        return gc.graph;
    }

    //Bellman Ford Algorithm-Single Source Shortest Path
    public void bellmanFord(Map<Object, List<Edge>> graph, Object[] nodes, Object source) {
        Map<Object, Integer> weights = new HashMap<>();
        weights.put(source, 0);
        for (Object ob : nodes) {
            if (source == ob) continue;
            weights.put(ob, Integer.MAX_VALUE);
        }
        for (int i = 0; i < nodes.length - 1; i++) relaxEdges(graph, weights);
        Map<Object, Integer> weights1 = Map.copyOf(weights);
        relaxEdges(graph, weights);
        if (weights.equals(weights1)) System.out.println("No negative cycle!");
        else System.out.println("Negative cycle!!!!");

    }

    void relaxEdges(Map<Object, List<Edge>> graph, Map<Object, Integer> weights) {
        graph.forEach((src, val) -> {
            val.forEach(edge -> {
                int totalWeights = weights.get(src) + edge.weight;
                if (totalWeights < weights.get(edge.destination)) weights.put(edge.destination, totalWeights);
            });
        });
    }

    //Dijkstra Algorithm - Single Source Shortest Path


    public void dijkstra(Map<Object, List<Edge>> graph, Object[] nodes, Object source) {
        List<Object> path = new LinkedList<>();
        Map<Object, Integer> weights = new HashMap<>();
        path.add(source);
        weights.put(source, 0);
        for (Object i : nodes) {
            if (i == source) continue;
            weights.put(i, Integer.MAX_VALUE);
        }
        boolean willNotContinue = relaxEdgesDijkstra(graph, weights, source);
        for (int i = 0; i < nodes.length-1; i++) {
            if (willNotContinue) break;
            Object node = findMin(weights, path);
            path.add(node);
            willNotContinue = relaxEdgesDijkstra(graph, weights, node);
        }
        System.out.println(path);
    }
    <K, V extends Comparable<? super V>> K findMin(Map<K, V> map, List<Object> path) {
        K keyForMinValue = null;
        V minValue = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if ((minValue == null || entry.getValue().compareTo(minValue) < 0) && !path.contains(entry.getKey())) {
                minValue = entry.getValue();
                keyForMinValue = entry.getKey();
            }
        }
        return keyForMinValue;
    }
    boolean relaxEdgesDijkstra(Map<Object, List<Edge>> graph, Map<Object, Integer> weights, Object source ) {
        if(!graph.containsKey(source)) return true;
            for (Edge edge : graph.get(source)) {
                int totalWeights = weights.get(source) + edge.weight;
                if (totalWeights < weights.get(edge.destination))
                    weights.put(edge.destination, totalWeights);
            }
            return false;
    }

}

class Edge {
    Object destination;
    int weight;


    public Edge(Object destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}


class GraphCreation {
    Map<Object, List<Edge>> graph = new HashMap<>();
    List<Edge> edgeList;
    Edge edge;


    public void addEdge(Object src, Object des, int weight) {
        edge = new Edge(des, weight);
        if (graph.containsKey(src)) graph.get(src).add(edge);
        else {
            edgeList = new ArrayList<>();
            edgeList.add(edge);
            graph.put(src, edgeList);
        }
    }
}
