import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class WeightedGraph<V> {
    private final Map<Vertex<V>, List<Edge<V>>> map = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        map.get(source).add(new Edge<>(source, destination, weight));
        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight); // If the graph is undirected
    }

    public List<Edge<V>> getAdjVertices(Vertex<V> vertex) {
        return map.get(vertex);
    }
}
