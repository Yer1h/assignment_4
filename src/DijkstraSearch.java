import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DijkstraSearch<V> {
    private final Map<Vertex<V>, Integer> distances = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
    private final PriorityQueue<VertexDistancePair<V>> priorityQueue;

    public DijkstraSearch() {
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(VertexDistancePair::getDistance));
    }

    public void dijkstra(WeightedGraph<V> graph, Vertex<V> start) {
        distances.put(start, 0);
        priorityQueue.add(new VertexDistancePair<>(start, 0));

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll().getVertex();

            for (Edge<V> edge : graph.getAdjVertices(current)) {
                Vertex<V> neighbor = edge.getDestination();
                int newDist = distances.get(current) + edge.getWeight().intValue();

                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    previousVertices.put(neighbor, current);
                    priorityQueue.add(new VertexDistancePair<>(neighbor, newDist));
                }
            }
        }
    }

    public List<Vertex<V>> getShortestPath(Vertex<V> end) {
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> at = end; at != null; at = previousVertices.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}

class VertexDistancePair<V> {
    private final Vertex<V> vertex;
    private final int distance;

    public VertexDistancePair(Vertex<V> vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex<V> getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }
}
