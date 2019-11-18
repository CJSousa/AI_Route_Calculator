package searchalgorithm;
import java.util.*;
import searchproblem.*;

public class GraphSearch {

	private boolean done = false;
	private SearchProblem problem;
	private Node goal;
	private Queue<Node> frontier;
	private HashMap<Node,Node> explored;
	
	private long maxfrontier;
	private long expansions;
	private long generated;
	private long repeated;
	private long time;
	
	public GraphSearch(SearchProblem p, Queue<Node> q) {
		problem = p;
		goal = null;
		frontier = q;
		explored = new HashMap<Node,Node>(1024,(float) 0.75);
		expansions = 0;
		generated = 0;
		maxfrontier = 0;
	}
	
	public Node searchSolution() {
		if( !done ) {
			
			long startTime = System.nanoTime();		
			goal = search();
			time = System.nanoTime() - startTime;
			done = true;
			frontier = null;
			problem = null;
		}
		return goal;
	}

	private Node search() {		
		frontier.clear();
		frontier.add(new Node(problem.getInitial()));
		generated++;
		for(;;) {
			if( frontier.isEmpty() ) {
				return null;
			}
			Node n = frontier.remove();
			if( problem.goalTest(n.getState())) {
				return n;
			}
			Node e = explored.get(n);			
			if( e == null ) {
				expansions++;
				List<Node> children = n.Expand();
				explored.put(n,n);
				generated += children.size();
				frontier.addAll(children);
				if (frontier.size() > maxfrontier)
					maxfrontier = frontier.size();
			} else {
				repeated++;
			}
		}
	}
	
	public Map<String,Number> getMetrics() {
		Map<String,Number> metrics = new LinkedHashMap<String,Number>();
		
		metrics.put("Node Expansions",expansions);
		metrics.put("Nodes Generated",generated);
		metrics.put("State repetitions",repeated);
		metrics.put("Max size frontier",maxfrontier);
		metrics.put("Size explored",explored.size());
		metrics.put("Runtime (ms)", time/1E6);
		
		return metrics;
	}

}
