package lesson_7;

public class Vertex {

    private final String label;
    private boolean visited;
    private Vertex provenVertex;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setProvenVertex(Vertex provenVertex) {
        this.provenVertex = provenVertex;
    }

    public Vertex getProvenVertex() {
        return provenVertex;
    }
}
