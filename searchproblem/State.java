package searchproblem;
import java.util.*;
import undirectedgraph.*;
  
public class State {
	Vertex location;
	
	public State(Vertex location) {
		this.location = location;
	}
	
	@Override
	public Object clone() {
		return new State(location);
	}

	@Override
	public int hashCode() {
		return location.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final State other = (State) obj;
		return this.location.equals(other.location);
	}

	public List<Arc> successorFunction() {		
		List<Arc> children = new ArrayList<Arc>(this.location.getNeigborCount());
		for (Edge e: this.location.getNeighbors()) children.add(successorState(e));
		return children;
	}

	public Arc successorState(Edge e) {
		State child = (State) this.clone();
		child.location = e.getNeighbor(this.location);
		return new Arc(this,child,e.getWeight());
	}
	
	public String toString() {
		return this.location.toString();
	}
}
