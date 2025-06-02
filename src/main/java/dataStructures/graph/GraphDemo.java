package dataStructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphDemo {

    /**
     * Represents a bidirectional graph using an adjacency list.
     * The graph is represented as a map where the key is the vertex and the value is a list of adjacent vertices.
     */
    private final Map<String, ArrayList<String>> adjList = new HashMap<>();

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex - the vertex to be added
     */
    public void addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            System.out.println("Adding vertex: " + vertex);
            adjList.put(vertex, new ArrayList<>());
        } else {
            System.out.println("Vertex " + vertex + " already exists.");
        }
    }

    /**
     * Adds an edge between two vertices in the graph.
     * If either vertex does not exist, it will not add the edge and will print an error message.
     *
     * @param vertex1 - the first vertex
     * @param vertex2 - the second vertex
     */
    public void addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            System.out.println("Edge added between " + vertex1 + " and " + vertex2);
        } else {
            System.out.println("One or both vertices do not exist. Cannot add edge.");
        }
    }

    /**
     * Removes an edge between two vertices from the graph.
     *
     * @param vertex1 - the first vertex
     * @param vertex2 - the second vertex
     */
    public void removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            System.out.println("Edge removed between " + vertex1 + " and " + vertex2);
        } else {
            System.out.println("One or both vertices do not exist. Cannot remove edge.");
        }

    }

    /**
     * Removes a vertex and all its associated edges from the graph.
     *
     * @param vertex - the vertex to be removed
     */
    public void removeVertex(String vertex) {
        if (adjList.get(vertex) != null) {
            for (String edge : adjList.get(vertex)) {
                adjList.get(edge).remove(vertex);
            }
            adjList.remove(vertex);
            System.out.println("Vertex " + vertex + " and its edges have been removed.");
        } else {
            System.out.println("Vertex " + vertex + " does not exist.");
        }
    }

    public static void main(String[] args) {
        GraphDemo graph = new GraphDemo();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.printGraph();

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.printGraph();

        graph.removeEdge("A", "B");
        graph.printGraph();

        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("A", "E");
        graph.printGraph();

        graph.removeVertex("A");
        graph.printGraph();
    }

    /**
     * Prints the adjacency list representation of the graph.
     */
    private void printGraph() {
        System.out.println("\nGraph adjacency list : ");
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            ArrayList<String> edges = adjList.get(vertex);
            System.out.print(edges);
            System.out.println();
        }
        System.out.println();
    }

}
