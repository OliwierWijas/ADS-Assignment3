public class Vertex
{
  private final String vertex;

  public Vertex(String vertex) {
    this.vertex = vertex;
  }

  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }

    Vertex other = (Vertex) obj;
    return this.vertex.equals(other.vertex);
  }

  @Override public String toString()
  {
    return vertex;
  }
}
