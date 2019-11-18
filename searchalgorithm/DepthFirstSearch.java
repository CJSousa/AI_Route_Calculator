package searchalgorithm;
import java.util.*;
import searchproblem.SearchProblem;

public class DepthFirstSearch extends SearchAlgorithm {
	private boolean done = false;
	private SearchProblem problem;
	private Node goal;
	
	private long expansions;
	private long generated;
	private long repeated;
	private long time;
	
	public DepthFirstSearch(SearchProblem p) {
		this.problem = p;
	}

	public Node searchSolution() {
		if( !done ) {
			long startTime = System.nanoTime();		
			goal = search(new Node(problem.getInitial()), new HashSet<Node>());
			time = System.nanoTime() - startTime;
			done = true;
			problem = null;
		}
		return goal;
	}
	
	private Node search(Node n, Set<Node> ancestors) {
		
		if (ancestors.contains(n)) {
			repeated++;
			return null;
		} else if( problem.goalTest(n.getState()) )
			return n;
		
		ancestors.add(n);
		List<Node> children = n.Expand();
		expansions++;
		generated += children.size();
		for(Node successor : children ) {
			Node result = search(successor,ancestors);
			if( result != null )
				return result;
		}
		ancestors.remove(n);
		return null;
	}
	
	public Map<String,Number> getMetrics() {
		Map<String,Number> metrics = new LinkedHashMap<String,Number>();
		
		metrics.put("Node Expansions",expansions);
		metrics.put("Nodes Generated",generated);
		metrics.put("State repetitions",repeated);		
		metrics.put("Runtime (ms)", time/1E6);
		
		return metrics;
	}

}
