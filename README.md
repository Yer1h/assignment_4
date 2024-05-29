Graph Algorithms Implementation in Java
This Java project implements several graph algorithms including Breadth-First Search (BFS), Depth-First Search (DFS), and Dijkstra's algorithm for finding the shortest path in a weighted graph. The project is divided into multiple classes, each responsible for a specific task.

Classes Overview:
Vertex<V>: Represents a vertex in the graph. Each vertex has associated data and adjacent vertices with their respective edge weights.

Edge<V>: Represents an edge between two vertices in the graph. Each edge has a source, destination, and weight.

WeightedGraph<V>: Represents a weighted graph. It provides methods to add vertices, edges, and retrieve adjacent vertices for a given vertex.

MyGraph<V>: Extends WeightedGraph to add bidirectional edges, simplifying the addition of edges for undirected graphs.

Search<V>: An abstract class providing a common structure for BFS and DFS algorithms. It maintains information about marked vertices and the edge-to relationship during traversal.

BreadthFirstSearch<V>: Implements the Breadth-First Search algorithm for traversing the graph from a starting vertex.

DepthFirstSearch<V>: Extends Search to implement the Depth-First Search algorithm recursively.

DijkstraSearch<V>: Implements Dijkstra's algorithm for finding the shortest path in a weighted graph from a given source vertex.

Usage:
To use the implemented algorithms:

Create a MyGraph object.
Add vertices using the addVertex method.
Add edges using the addEdge or addBidirectionalEdge methods.
Instantiate BFS, DFS, or DijkstraSearch objects with the graph and desired starting vertex.
Call the respective algorithm methods (bfs, dfs, or dijkstra).
Example:
public static void main(String[] args) {
    MyGraph<String> graph = new MyGraph<>();

    Vertex<String> newYork = new Vertex<>("New York");
    // Add vertices...

    graph.addEdge(newYork, losAngeles, 4.0);
    // Add edges...

    // Use BFS
    BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
    bfs.bfs(graph, newYork);

    // Use DFS
    DepthFirstSearch<String> dfs = new DepthFirstSearch<>(graph, newYork);
    // Perform operations with DFS...

    // Use Dijkstra's algorithm
    DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
    dijkstra.dijkstra(graph, newYork);
}
Notes:
*This project provides basic implementations of graph algorithms. For large graphs or performance-critical applications, consider optimizations or alternative algorithms.
*Ensure proper error handling and input validation when using the provided classes and methods.
