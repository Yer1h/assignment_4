import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        Vertex v1 = new Vertex("1", "A");
        Vertex v2 = new Vertex("2", "B");
        Vertex v3 = new Vertex("3", "C");
        Vertex v4 = new Vertex("4", "D");
        Vertex v5 = new Vertex("5", "E");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1, v2, 4);
        graph.addEdge(v1, v3, 1);
        graph.addEdge(v2, v4, 1);
        graph.addEdge(v3, v4, 5);
        graph.addEdge(v4, v5, 3);

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        System.out.println("BFS starting from vertex A:");
        bfs.bfs(graph, v1);
        System.out.println();

        DijkstraSearch dijkstra = new DijkstraSearch();
        dijkstra.dijkstra(graph, v1);
        System.out.println("Dijkstra's shortest path from A to E:");
        List<Vertex> path = dijkstra.getShortestPath(v5);
        path.forEach(vertex -> System.out.print(vertex + " "));
    }
}
