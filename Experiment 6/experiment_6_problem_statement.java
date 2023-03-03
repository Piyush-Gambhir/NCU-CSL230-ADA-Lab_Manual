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
        List<Edge> edges;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new ArrayList<>();
        }

        public void addEdge(Edge e) {
            edges.add(e);
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
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.edges.size(); j++) {
                if (graph.edges.get(j).src == i) {
                    System.out.print(graph.edges.get(j).dest + "(" + graph.edges.get(j).weight + ") ");
                }
            }
            System.out.println();
        }
    }

    public static Graph kruskalMinimumSpanningTree(Graph graph) {
        Graph MST = new Graph(graph.V, graph.V - 1);
        Edge[] edges = new Edge[graph.E];
        for (int i = 0; i < graph.E; i++) {
            edges[i] = graph.edges.get(i);
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        Subset[] subsets = new Subset[graph.V];
        for (int i = 0; i < graph.V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i = 0;
        int j = 0;
        while (j < graph.V - 1) {
            Edge e = edges[i++];
            int x = find(subsets, e.src);
            int y = find(subsets, e.dest);
            if (x != y) {
                MST.addEdge(e);
                j++;
                union(subsets, x, y);
            }
        }
        return MST;
    }

    public static void main(String[] args) {

        int V = 4;
        int E = 5;

        Graph graph = new Graph(V, E);

        graph.addEdge(new Edge(0, 1, 10));
        graph.addEdge(new Edge(0, 2, 6));
        graph.addEdge(new Edge(0, 3, 5));
        graph.addEdge(new Edge(1, 3, 15));
        graph.addEdge(new Edge(2, 3, 4));

        System.out.println("Given Graph: \n");
        printGraph(graph);

        Graph MST = kruskalMinimumSpanningTree(graph);
        System.out.println("Minimum Spanning Tree of Given Graph: \n");
        printGraph(MST);
    }
}