import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch<V> {
    private final Map<Vertex<V>, Boolean> visited = new HashMap<>();

    public void bfs(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.poll();
            System.out.print(vertex.getData() + " ");

            for (Edge<V> edge : graph.getAdjVertices(vertex)) {
                Vertex<V> v = edge.getDestination();
                if (!visited.containsKey(v)) {
                    queue.add(v);
                    visited.put(v, true);
                }
            }
        }
    }
}
