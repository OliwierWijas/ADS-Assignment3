import java.util.ArrayList;

public class VerticesList
{
  private final ArrayList<Vertex> vertices;

  public VerticesList() {
    this.vertices = new ArrayList<>();
  }

  public void add(Vertex vertex) {
    this.vertices.add(vertex);
  }

  public boolean contains(Vertex vertex) {
    for (Vertex vertex1 : vertices) {
      if (vertex.equals(vertex1))
        return true;
    }
    return false;
  }

  public ArrayList<Vertex> getVertices() {
    return vertices;
  }
}
