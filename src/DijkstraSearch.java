import java.util.*;

public class DijkstraSearch {
    private final Map<Vertex, Integer> distances = new HashMap<>();
    private final Map<Vertex, Vertex> previousVertices = new HashMap<>();
    private final PriorityQueue<VertexDistancePair> priorityQueue;

    public DijkstraSearch() {
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(VertexDistancePair::getDistance));
    }

    public void dijkstra(WeightedGraph graph, Vertex start) {
        distances.put(start, 0);
        priorityQueue.add(new VertexDistancePair(start, 0));

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll().getVertex();

            for (Edge edge : graph.getAdjVertices(current)) {
                Vertex neighbor = edge.getDestination();
                int newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    previousVertices.put(neighbor, current);
                    priorityQueue.add(new VertexDistancePair(neighbor, newDist));
                }
            }
        }
    }

    public List<Vertex> getShortestPath(Vertex end) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex at = end; at != null; at = previousVertices.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}

class VertexDistancePair {
    private final Vertex vertex;
    private final int distance;

    public VertexDistancePair(Vertex vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }
}
