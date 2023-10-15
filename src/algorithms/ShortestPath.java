package algorithms;

import dataStructure.nonLinear.Graph;

import java.util.Map.Entry;
import java.util.*;

public class ShortestPath {
    Map<Object, List<Object>> graph;
    GraphCreation gc = new GraphCreation();
    int infinite = Integer.MAX_VALUE;

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
        gc.addEdge(2, 3, 10);
        gc.addEdge(2, 4, 15);
        gc.addEdge(3, 5, 30);
        gc.addEdge(4, 1, 10);
        gc.addEdge(4, 5, 15);
        gc.addEdge(5, 2, 20);
        gc.addEdge(5, 2, 20);
        gc.addEdge(5, 3, 35);
        gc.addEdge(6, 5, 3);

//        gc.addEdge(1, 2, 20);
//        gc.addEdge(2, 3, 10);
//        gc.addEdge(1, 3, 4);
    }

    public Object[][] makeTwoDArrayGraph() {
//        return new Object[][]{{0, 3, infinite, 5},
//                {2, 0, infinite, 8},
//                {infinite, 1, 0, infinite},
//                {infinite, infinite, 2, 0}};

//        return new Object[][]{{0, 8, infinite, 1},
//                {infinite, 0, 1, infinite},
//                {4, infinite, 0, infinite},
//                {infinite, 2, 9, 0}};

        return new Object[][]{{0, 1, infinite, infinite},
                {infinite, 0, -1, infinite},
                {infinite, infinite, 0, -1},
                {-1, infinite, infinite, 0}};
    }

    public void printTwoDArray(Object[][] graph) {
        for (Object[] row : graph) {
            for (Object column : row) System.out.print(column + " ");
            System.out.println();
        }
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
            weights.put(ob, infinite);
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
            weights.put(i, infinite);
        }
        boolean willNotContinue = relaxEdgesDijkstra(graph, weights, source);
        for (int i = 0; i < nodes.length - 1; i++) {
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

    boolean relaxEdgesDijkstra(Map<Object, List<Edge>> graph, Map<Object, Integer> weights, Object source) {
        if (!graph.containsKey(source)) return true;
        for (Edge edge : graph.get(source)) {
            int totalWeights = weights.get(source) + edge.weight;
            if (totalWeights < weights.get(edge.destination))
                weights.put(edge.destination, totalWeights);
        }
        return false;
    }


    //Detecting negative cycle using Floyd Warshall
    public boolean isNegativeCycle(Object[][] graph) {
        for (int i = 0; i < graph.length; i++)
            if ((int) graph[i][i] < 0) return true;
        return false;
    }
    public Object[][] floydWarshall(Object[][] graph) {
        int v = graph.length;
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if ((int) graph[i][k] == infinite || (int) graph[k][j] == infinite) continue;
                    if ((int) graph[i][k] + (int) graph[k][j] < (int) graph[i][j])
                        graph[i][j] = (int) graph[i][k] + (int) graph[k][j];
                }
            }
        }
        return graph;
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
