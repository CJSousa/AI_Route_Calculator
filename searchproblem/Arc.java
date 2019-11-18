package searchproblem;

public class Arc {

	private State source;
	private State destination;
	private double c;

	public Arc(State source, State destination, double c) {
		this.source = source;
		this.destination = destination;
		this.c = c;
	}
	
	public State getParent() {
		return source;
	}
	
	public State getChild() {
		return destination;
	}
	
	public double getStepCost() {
		return c;
	}
		
	public String toString() {
		return source.toString() + "(" + c + ")->" + destination.toString();
	}

}
