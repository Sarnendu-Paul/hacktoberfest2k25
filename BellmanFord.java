import java.util.Arrays;
import java.util.Stack;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFordWithPath {

    public static void bellmanFord(int vertices, Edge[] edges, int source) {
        int[] distance = new int[vertices];
        int[] parent = new int[vertices]; // To store the path
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[source] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (distance[edge.src] != Integer.MAX_VALUE &&
                    distance[edge.src] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.src] + edge.weight;
                    parent[edge.dest] = edge.src;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (distance[edge.src] != Integer.MAX_VALUE &&
                distance[edge.src] + edge.weight < distance[edge.dest]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print distances and paths
        System.out.println("Vertex\tDistance\tPath from Source " + source);
        for (int i = 0; i < vertices; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(i + "\t\tINF\t\tNo path");
            } else {
                System.out.print(i + "\t\t" + distance[i] + "\t\t");
                printPath(i, parent);
                System.out.println();
            }
        }
    }

    // Helper function to print path using parent array
    private static void printPath(int vertex, int[] parent) {
        Stack<Integer> stack = new Stack<>();
        int current = vertex;
        while (current != -1) {
            stack.push(current);
            current = parent[current];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) System.out.print(" -> ");
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = new Edge[8];

        // Create a sample graph
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        int source = 0;
        bellmanFord(vertices, edges, source);
    }
}
