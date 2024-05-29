import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> v1 = new Vertex<>("New York");
        Vertex<String> v2 = new Vertex<>("Los Angeles");
        Vertex<String> v3 = new Vertex<>("Chicago");
        Vertex<String> v4 = new Vertex<>("Houston");
        Vertex<String> v5 = new Vertex<>("Phoenix");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1, v2, 4.0);
        graph.addEdge(v1, v3, 1.0);
        graph.addEdge(v2, v4, 1.0);
        graph.addEdge(v3, v4, 5.0);
        graph.addEdge(v4, v5, 3.0);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println("BFS starting from vertex New York:");
        bfs.bfs(graph, v1);
        System.out.println();

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        dijkstra.dijkstra(graph, v1);
        System.out.println("Dijkstra's shortest path from New York to Phoenix:");
        List<Vertex<String>> path = dijkstra.getShortestPath(v5);
        path.forEach(vertex -> System.out.print(vertex.getData() + " "));
    }
}
