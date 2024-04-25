public class Edge
{
  private final int weight;
  private final Vertex to;

  public Edge(Vertex to, int weight) {
    this.to = to;
    this.weight = weight;
  }

  public Vertex getTargetVertex() {
    return to;
  }

  public int getWeight() {
    return weight;
  }
}
