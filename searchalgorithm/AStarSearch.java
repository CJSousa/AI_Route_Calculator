package searchalgorithm;
import java.util.*;
import searchproblem.SearchProblem;
import searchproblem.State;

public class AStarSearch extends SearchAlgorithm {
	
	private GraphSearch graph;

	public AStarSearch(final SearchProblem p) {
		Queue<Node> pqueue = new PriorityQueue<Node>(101, new Comparator<Node>() {	
			public int compare(Node o1, Node o2) {
			State n1 = o1.getState();
			State n2 = o2.getState();
			if( o1.getPathCost() + p.heuristic(n1)> o2.getPathCost() + p.heuristic(n2) )
				return 1;
			else if ( o1.getPathCost() + p.heuristic(n1) < o2.getPathCost() + p.heuristic(n2) )
				return -1;
			else
				return 0;
			}});
		graph = new GraphSearch(p,pqueue);
	}

	public Node searchSolution() {
		return graph.searchSolution();
	}
	
	public Map<String,Number> getMetrics() {
		return graph.getMetrics();
	}

}
