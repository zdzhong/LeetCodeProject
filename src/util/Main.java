package util;

class Graph {
    int vertices;
    int[][] adjMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && hasCycleUtil(i, -1, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor = 0; neighbor < vertices; neighbor++) {
            if (adjMatrix[vertex][neighbor] == 1) {
                if (!visited[neighbor]) {
                    if (hasCycleUtil(neighbor, vertex, visited)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        if (graph.hasCycle()) {
            System.out.println("Graph has a cycle.");
        } else {
            System.out.println("Graph does not have a cycle.");
        }
    }
}