import java.util.*;

public class WeightedGraph {
    private final Map<Vertex, List<Edge>> adjVertices = new HashMap<>();

    public void addVertex(Vertex vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, int weight) {
        adjVertices.get(vertex1).add(new Edge(vertex2, weight));
        adjVertices.get(vertex2).add(new Edge(vertex1, weight));
    }

    public List<Edge> getAdjVertices(Vertex vertex) {
        return adjVertices.get(vertex);
    }
}
