import java.util.*;

public class Graph {
  private final Map<Vertex, List<Edge>> graph;
  private final Map<Vertex, Integer> distances;
  private final Map<Vertex, Vertex> parents;

  public Graph() {
    this.graph = new HashMap<>();
    this.parents = new HashMap<>();
    this.distances = new HashMap<>();
  }

  public void addVertex(Vertex vertex) {
    graph.put(vertex, new ArrayList<>());
  }

  public void addEdge(Vertex from, Vertex to, int weight) {
    graph.get(from).add(new Edge(to, weight));
  }

  public List<Edge> getAdjacencyList(Vertex vertex) {
    return graph.get(vertex);
  }

  public Set<Vertex> getAllVertices() {
    return graph.keySet();
  }

  public Map<Vertex, Integer> getDistances()
  {
    return distances;
  }

  public Map<Vertex, Vertex> getParents()
  {
    return parents;
  }
}