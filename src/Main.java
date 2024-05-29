import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        Vertex<String> newYork = new Vertex<>("New York");
        Vertex<String> losAngeles = new Vertex<>("Los Angeles");
        Vertex<String> chicago = new Vertex<>("Chicago");
        Vertex<String> houston = new Vertex<>("Houston");
        Vertex<String> phoenix = new Vertex<>("Phoenix");

        graph.addVertex(newYork);
        graph.addVertex(losAngeles);
        graph.addVertex(chicago);
        graph.addVertex(houston);
        graph.addVertex(phoenix);

        graph.addBidirectionalEdge(newYork, losAngeles, 4.0);
        graph.addBidirectionalEdge(newYork, chicago, 1.0);
        graph.addBidirectionalEdge(losAngeles, houston, 1.0);
        graph.addBidirectionalEdge(chicago, houston, 5.0);
        graph.addBidirectionalEdge(houston, phoenix, 3.0);

        System.out.println("BFS starting from New York:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        bfs.bfs(graph, newYork);
        System.out.println();

        System.out.println("DFS starting from New York:");
        DepthFirstSearch<String> dfs = new DepthFirstSearch<>(graph, newYork);
        for (Vertex<String> v : dfs.pathTo(phoenix)) {
            System.out.print(v.getData() + " ");
        }
        System.out.println();

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        dijkstra.dijkstra(graph, newYork);
        System.out.println("Dijkstra's shortest path from New York to Phoenix:");
        List<Vertex<String>> path = dijkstra.getShortestPath(phoenix);
        path.forEach(vertex -> System.out.print(vertex.getData() + " "));
    }
}
