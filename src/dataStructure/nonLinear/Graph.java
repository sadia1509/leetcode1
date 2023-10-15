package dataStructure.nonLinear;

import algorithms.ShortestPath;

import java.util.*;

public class Graph {
    Map<Object, List<Object>> graph;
    int cycleNumber=0, n=100;
    Vector<Integer>[] graphV= new Vector[n], cycles= new Vector[n];

    void addEdges(Object node, List<Object> edges) {
        graph.put(node, edges);
    }
    void addEdge(int u, int v) {
//        graphV[u] = new Vector<>();
//        graphV[v] = new Vector<>();
        graphV[u].add(v);
        graphV[v].add(u);
    }

    public Map<Object, List<Object>> getGraph() {
        return graph;
    }
    public Vector<Integer>[] getGraphV(){return graphV;}

    public void makePracticeGraph() {
        graph = new HashMap<>();
        //0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
        //2 -> 0, 0 -> 2, 1 -> 2, 0 -> 1, 3 -> 3, 1 -> 3
        addEdges(0, Arrays.asList(1, 2));
        addEdges(1, Arrays.asList(2));
        addEdges(2, Arrays.asList(3));
        addEdges(3, Arrays.asList(3));
        System.out.println(getGraph());
    }

    public void makeNonCyclicGraph() {
        graph = new HashMap<>();
        addEdges(0, Arrays.asList(1));
        addEdges(1, Arrays.asList(2));
        addEdges(2, Arrays.asList(3));
//        addEdges(3, Arrays.asList(3));
    }

    public void makeCyclicGraph() {
        graph = new HashMap<>();
        addEdges(0, Arrays.asList(1, 2));
        addEdges(1, Arrays.asList(2));
        addEdges(2, Arrays.asList(0, 3));
        addEdges(3, Arrays.asList(3));
    }

    public void makeTransitiveClosureGraph() {
        graph = new HashMap<>();
        addEdges(0, Arrays.asList(1, 2));
        addEdges(1, Arrays.asList(2));
        addEdges(2, Arrays.asList(0, 3));
        addEdges(3, Arrays.asList(3));
    }

    public void makeIntegerDisconnectedGraph() {
        graph = new HashMap<>();
        addEdges(0, Arrays.asList(4));
        addEdges(1, Arrays.asList(2, 3, 4));
        addEdges(2, Arrays.asList(3));
        addEdges(3, Arrays.asList(4));
    }

    public void makeIntegerGraph() {
        graph = new HashMap<>();
        addEdges(0, Arrays.asList(1, 2));
        addEdges(1, Arrays.asList(0, 2, 3));
        addEdges(2, Arrays.asList(0, 1, 4));
        addEdges(3, Arrays.asList(1, 4));
        addEdges(4, Arrays.asList(2, 3));
    }

    public void makeStringGraph() {
        graph = new HashMap<>();
        addEdges("a", Arrays.asList("b", "e", "d"));
        addEdges("b", Arrays.asList());
        addEdges("c", Arrays.asList("a"));
        addEdges("d", Arrays.asList("c"));
        addEdges("e", Arrays.asList("d", "b"));
    }

    //Depth First Search or DFS
    public void dfsTraversal(Map<Object, List<Object>> graph, int startingIndex) {
        boolean[] visited = new boolean[graph.size()];
        Stack stack = new Stack();
        visited[startingIndex] = true;
        stack.add(startingIndex);


        while (!stack.isEmpty()) {
            Object removed = stack.pop();
            System.out.print(removed + " ");
            graph.get(removed).forEach(n -> {
                        if (!visited[(int) n]) {
                            visited[(int) n] = true;
                            stack.add(n);
                        }
                    }
            );
        }
        System.out.println();
    }

    //BFS for Disconnected Graph
    public void disconnectedBfsTraversal(Map<Object, List<Object>> graph, int nodeCount) {
        Queue queue = new LinkedList();
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) visited.add(i, false);
        graph.keySet().forEach(k -> {
                    if (!visited.get((int) k)) bfsCheck(graph, visited, queue, (int) k);
                }
        );
    }

    void bfsCheck(Map<Object, List<Object>> graph, List<Boolean> visited, Queue queue, int key) {
        visited.set(key, true);
        queue.add(key);
        while (!queue.isEmpty()) {
            Object removed = queue.remove();
            System.out.print(removed + " ");
            if (!graph.containsKey(removed)) continue;
            graph.get(removed).forEach(val -> {
                if (!visited.get((int) val)) {
                    visited.set((int) val, true);
                    queue.add(val);
                }
            });
        }
    }

    //Breadth First Search or BFS
    public void bfsTraversal(Map<Object, List<Object>> graph, int startingIndex) {
        boolean[] visited = new boolean[graph.size()];
        Queue queue = new LinkedList<Integer>();
        visited[startingIndex] = true;
        queue.add(startingIndex);

        while (!queue.isEmpty()) {
            Object removed = queue.remove();
            System.out.print(removed + " ");
            graph.get(removed).forEach(n -> {
                        if (!visited[(int) n]) {
                            visited[(int) n] = true;
                            queue.add(n);
                        }
                    }
            );
        }
        System.out.println();
    }


    //Convert to Transpose graph
    public void convertToTranspose(Map<Object, List<Object>> graph) {
        Map<Object, List<Object>> transposeGraph = new HashMap<>();
        System.out.println(graph);
        graph.forEach((key, value) -> {
            value.forEach(val -> {
                        if (transposeGraph.containsKey(val)) transposeGraph.get(val).add(key);
                        else {
                            List<Object> newList = new ArrayList<>();
                            newList.add(key);
                            transposeGraph.put(val, newList);
                        }
                    }
            );
        });
        System.out.println(transposeGraph);
    }

    //Transitive Closure of a Graph using DFS
    public void transitiveClosureDfs(Map<Object, List<Object>> graph) {
        int graphSize = graph.size();
        Object[][] matrix = new Object[graphSize][graphSize];
        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                if (i == j || graph.get(i).contains(j)) matrix[i][j] = 1;
                else matrix[i][j] = dfsCheck(graph, i, j) ? 1 : 0;
            }
        }
        for (Object[] rw : matrix) {
            for (Object cl : rw) System.out.print(cl + " ");
            System.out.println();
        }
    }

    boolean dfsCheck(Map<Object, List<Object>> graph, Object source, Object destination) {
        Boolean[] visited = new Boolean[graph.size()];
        Arrays.fill(visited, false);
        Stack stack = new Stack();
        visited[(int) source] = true;
        stack.add(source);
        while (!stack.isEmpty()) {
            Object removed = stack.pop();
            if (removed == destination) return true;
            graph.get(removed).forEach(key -> {
                int k = (int) key;
                if (!visited[k]) {
                    visited[k] = true;
                    stack.add(k);
                }
            });
        }
        return false;
    }

    //Detect cycle in an undirected graph
    public void detectCycleDfs(Map<Object, List<Object>> graph, int nodeCount) {
        boolean result = false;
        int graphSize = nodeCount;
        boolean[] visited = new boolean[graphSize];
        boolean[] recStack = new boolean[graphSize];
        for (int i = 0; i < graphSize; i++) {
            if (isCyclic(i, graph, visited, recStack)) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }

    boolean isCyclic(int i, Map<Object, List<Object>> graph, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) return true;
        if (visited[i]) return false;
        visited[i] = true;
        recStack[i] = true;
        List<Object> children = graph.get(i);
        if (children != null) {
            for (Object child : children)
                if (isCyclic((int) child, graph, visited, recStack)) return true;
        }
        recStack[i] = false;
        return false;
    }

    //Detect cycle in a directed graph TODO
    public void detectCycleDfsDirected(Map<Object, List<Object>> graph) {
        boolean result = false;
        int n = graph.size();
        boolean[] visited = new boolean[n];
        boolean[] recursionStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && isCyclicDirected(i, graph, visited, recursionStack)) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }

    boolean isCyclicDirected(int vertex, Map<Object, List<Object>> graph, boolean[] visited, boolean[] recursionStack) {
        visited[vertex] = true;
        recursionStack[vertex] = true;
        int neighbor;
        for (Object neighborObject : graph.get(vertex)) {
            neighbor = (int) neighborObject;
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, graph, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true;
            }
        }

        recursionStack[vertex] = false;
        return false;
    }

    //Detect cycle in a direct graph using colors
    //Detect a negative cycle in a Graph | (Bellman Ford)
    public void detectNegativeCycle(){
        ShortestPath shortestPath = new ShortestPath();
        shortestPath.makeNegativeCyclicGraph();
        shortestPath.bellmanFord(shortestPath.getGraph(), new Object[]{1,2,3,4}, 1);
    }

    public void makeGraphUsingVector(){
        for (int i = 0; i < n; i++) {
            graphV[i] = new Vector<>();
            cycles[i] = new Vector<>();
        }
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 6);
        addEdge(4, 7);
        addEdge(5, 6);
        addEdge(3, 5);
        addEdge(7, 8);
        addEdge(6, 10);
        addEdge(5, 9);
        addEdge(10, 9);
        addEdge(10, 11);
        addEdge(11, 12);
        addEdge(11, 13);
        addEdge(12, 13);
    }

    //Cycles of length n in an undirected and connected graph
   public void dfsCycles(int u, int p, int[] color, int[] parent, Vector<Integer>[] graph) {
        int partiallyVisited=1, completelyVisited=2;
        if (color[u] == completelyVisited) return;
        if (color[u] == partiallyVisited) {
            Vector<Integer> v = new Vector<>();
            int cur = p;
            v.add(cur);
            while (cur != u) {
                cur = parent[cur];
                v.add(cur);
            }
            cycles[cycleNumber++] = v;
            return;
        }
        parent[u] = p;
        color[u] = partiallyVisited;
        for (int v : graph[u]) {
            if (v == parent[u])  continue;
            dfsCycles(v, u, color, parent, graph);
        }
        color[u] = completelyVisited;
    }
    public void printCycles() {
        for (int i = 0; i < cycleNumber; i++) {
            System.out.printf("Cycle Number %d: ", i + 1);
            for (int x : cycles[i]) System.out.printf("%d ", x);
            System.out.println();
        }
    }

}
