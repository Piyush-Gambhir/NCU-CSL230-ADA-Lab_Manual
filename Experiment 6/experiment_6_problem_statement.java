/*
Implement Prim’s and Kruskal’s algorithms for finding minimum spanning tree of a given graph.
*/

import java.util.*;

/**
 * experiment_6_problem_statement
 */
public class experiment_6_problem_statement {

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge(0, 0, 0);
            }
        }
    }

    static class Subset {
        int parent, rank;
    }

    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public static void printGraph(Graph graph) {
        for (int i = 0; i < graph.V; i++) {
            System.out.print(i + " --- ");
            for (int j = 0; j < graph.E; j++) {
                if (graph.edges[j].src == i) {
                    System.out.print(graph.edges[j].dest + " (" + graph.edges[j].weight + ") ");
                } else if (graph.edges[j].dest == i) {
                    System.out.print(graph.edges[j].src + " (" + graph.edges[j].weight + ") ");
                }
            }
            System.out.println();
        }
    }

    public static Graph kruskalMinimumSpanningTree(Graph graph) {
        int V = graph.V;
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;

        Arrays.sort(graph.edges, Comparator.comparingInt(o -> o.weight));

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        while (e < V - 1) {
            Edge nextEdge = graph.edges[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Kruskal's Minimum Spanning Tree");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
        return graph;

    }

    public static void main(String[] args) {

        int V = 6;
        int E = 9;

        Graph graph = new Graph(V, E);
        graph.edges[0] = new Edge(0, 1, 4);
        graph.edges[1] = new Edge(0, 3, 3);
        graph.edges[2] = new Edge(0, 4, 7);
        graph.edges[3] = new Edge(1, 2, 2);
        graph.edges[4] = new Edge(1, 3, 9);
        graph.edges[5] = new Edge(1, 4, 5);
        graph.edges[6] = new Edge(2, 4, 8);
        graph.edges[7] = new Edge(2, 5, 5);
        graph.edges[8] = new Edge(4, 5, 6);

        printGraph(graph);
        kruskalMinimumSpanningTree(graph);
    }

}