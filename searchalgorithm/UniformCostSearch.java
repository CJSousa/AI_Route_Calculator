package searchalgorithm;
import java.util.*;
import searchproblem.SearchProblem;

public class UniformCostSearch extends SearchAlgorithm {

	private GraphSearch graph;
	
	public UniformCostSearch(SearchProblem p) {
		Queue<Node> pqueue = new PriorityQueue<Node>(11, new Comparator<Node>() {	
			public int compare(Node o1, Node o2) {
			if( o1.getPathCost() > o2.getPathCost() )
				return 1;
			else if ( o1.getPathCost() < o2.getPathCost() )
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
