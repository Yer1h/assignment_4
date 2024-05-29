public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(MyGraph<V> graph, Vertex<V> source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<V> graph, Vertex<V> current) {
        marked.add(current);

        for (Edge<V> edge : graph.getAdjVertices(current)) {
            Vertex<V> v = edge.getDestination();
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
