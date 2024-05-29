public class MyGraph<V> extends WeightedGraph<V> {
    public MyGraph() {
        super(true);
    }

    public MyGraph(boolean undirected) {
        super(undirected);
    }

    public void addBidirectionalEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        addEdge(source, destination, weight);
        addEdge(destination, source, weight);
    }
}
