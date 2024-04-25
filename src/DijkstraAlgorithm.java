import java.util.*;

class DijkstraAlgorithm {

  public static Map<Vertex, Integer> findShortestPath(Graph graph, Vertex startVertex) {
    PriorityQueue<Map.Entry<Vertex, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    Map<Vertex, Integer> distances = graph.getDistances();
    Map<Vertex, Vertex> parent = graph.getParents();
    VerticesList knownVertices = new VerticesList();

    // Initialize distances and priority queue
    for (Vertex vertex : graph.getAllVertices()) {
      if (vertex.equals(startVertex)) {
        distances.put(vertex, 0);
      } else {
        distances.put(vertex, Integer.MAX_VALUE);
      }
      priorityQueue.offer(new AbstractMap.SimpleEntry<>(vertex, distances.get(vertex)));
      parent.put(vertex, null);
    }

    while (!priorityQueue.isEmpty()) {
      Vertex currentVertex = priorityQueue.poll().getKey();
      if (!knownVertices.contains(currentVertex))
        knownVertices.add(currentVertex);

      for (Edge edge : graph.getAdjacencyList(currentVertex)) {
        Vertex neighbour = edge.getTargetVertex();
        if (!knownVertices.contains(neighbour))
        {
          int weight = edge.getWeight();
          int distanceThroughCurrent = distances.get(currentVertex) + weight;

          if (distanceThroughCurrent < distances.get(neighbour))
          {
            distances.put(neighbour, distanceThroughCurrent);
            parent.put(neighbour, currentVertex);
            priorityQueue.offer(new AbstractMap.SimpleEntry<>(neighbour,
                distances.get(neighbour)));
          }
        }
      }
    }

    return distances;
  }

  private static void printMap(Map<Vertex, ?> map) {
    for (Vertex vertex : map.keySet().stream().toList())
    {
      System.out.println("[" + vertex + " -> " + map.get(vertex) + "]");
    }
  }

  public static void main(String[] args)
  {
    Graph graph = new Graph();
    init(graph);
    Map<Vertex, Integer> solution = findShortestPath(graph, new Vertex("A"));
    printMap(solution);
    System.out.println();
    printMap(graph.getParents());
  }

  private static void init(Graph graph) {
    Vertex A = new Vertex("A");
    Vertex B = new Vertex("B");
    Vertex C = new Vertex("C");
    Vertex D = new Vertex("D");
    Vertex E = new Vertex("E");
    Vertex F = new Vertex("F");
    Vertex G = new Vertex("G");
    Vertex H = new Vertex("H");

    graph.addVertex(A);
    graph.addVertex(B);
    graph.addVertex(C);
    graph.addVertex(D);
    graph.addVertex(E);
    graph.addVertex(F);
    graph.addVertex(G);
    graph.addVertex(H);

    graph.addEdge(A, B, 2);
    graph.addEdge(A, E, 9);
    graph.addEdge(A, D, 7);
    graph.addEdge(A, C, 1);

    graph.addEdge(B, A, 2);
    graph.addEdge(B, E, 1);

    graph.addEdge(C, A, 1);
    graph.addEdge(C, G, 12);
    graph.addEdge(C, F, 6);

    graph.addEdge(D, A, 7);
    graph.addEdge(D, E, 3);
    graph.addEdge(D, G, 2);

    graph.addEdge(E, B, 1);
    graph.addEdge(E, A, 9);
    graph.addEdge(E, D, 3);
    graph.addEdge(E, G, 8);
    graph.addEdge(E, H, 7);

    graph.addEdge(F, C, 6);
    graph.addEdge(F, G, 2);

    graph.addEdge(G, F, 2);
    graph.addEdge(G, C, 12);
    graph.addEdge(G, D, 2);
    graph.addEdge(G, E, 8);
    graph.addEdge(G, H, 1);

    graph.addEdge(H, G, 1);
    graph.addEdge(H, E, 7);
  }
}
