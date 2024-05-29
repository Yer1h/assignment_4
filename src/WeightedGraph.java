import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<Vertex<V>, List<Edge<V>>> map = new HashMap<>();

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<V> v) {
        if (!map.containsKey(v)) {
            map.put(v, new LinkedList<>());
        }
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
        }
        if (!hasVertex(dest)) {
            addVertex(dest);
        }
        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirected) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public boolean hasVertex(Vertex<V> v) {
        return map.containsKey(v);
    }

    public List<Edge<V>> getAdjVertices(Vertex<V> v) {
        return map.get(v);
    }
}
