package undirectedgraph;
import java.util.*;

public class VertexSet {
	private HashSet<Vertex> vertices;
	private String label;
	
	public VertexSet(String label) {
		this.vertices = new HashSet<Vertex>();
		this.label = label;
	}
	
	public void addVertice(Vertex v) {
		this.vertices.add(v);
	}

	public HashSet<Vertex> getVertices() {
		return this.vertices;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public String toString() {
		String s = label + ": ";
		for (Vertex v: vertices) s = s + v.toString() + "; ";
		return s;
	}
}
