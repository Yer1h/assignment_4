import java.util.*;

public class BreadthFirstSearch {
    private final Map<Vertex, Boolean> visited = new HashMap<>();

    public void bfs(WeightedGraph graph, Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : graph.getAdjVertices(vertex)) {
                Vertex v = edge.getDestination();
                if (!visited.containsKey(v)) {
                    queue.add(v);
                    visited.put(v, true);
                }
            }
        }
    }
}
