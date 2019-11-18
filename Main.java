import undirectedgraph.*;
import searchalgorithm.*;
public class Main {

	public static void main(String[] args) {
        Graph graph = new Graph();
        graph.defineGraphRomenia();
        graph.showLinks();
        graph.showSets();
        Node n;
        
        /*One destination with 0 specific stops needed */
        n = graph.searchSolution("Giurgiu", "Sibiu", Algorithms.BreadthFirstSearch);
        graph.showSolution(n);
        graph.reset(); 
        
        n = graph.searchSolution("Giurgiu", "Sibiu", Algorithms.DepthFirstSearch);
        graph.showSolution(n);
        graph.reset();
        
        n = graph.searchSolution("Giurgiu", "Sibiu", Algorithms.GreedySearch);
        graph.showSolution(n);
        graph.reset();
        
        n = graph.searchSolution("Giurgiu", "Sibiu", Algorithms.UniformCostSearch);
        graph.showSolution(n);
        graph.reset();
        
        n = graph.searchSolution("Giurgiu", "Sibiu", Algorithms.AStarSearch);
        graph.showSolution(n);
        graph.reset();
    
        /*One destination with 1 specific stop needed */
        n = graph.searchSolutionWithStop("Fagaras", "Eforie", "Oltenia", Algorithms.AStarSearch);
        graph.showSolution(n);
        graph.reset();
        
        n = graph.searchSolutionWithStop("Fagaras", "Eforie", "Oltenia", Algorithms.DepthFirstSearch);
        graph.showSolution(n);
        graph.reset();
        
        /*One destination with as many specific stops as wished */
        String [] stopProvinces = new String [] {"Moldova", "Oltenia", "Transilvania", "Dobrogea"}; 
        n = graph.searchSolutionWithSeveralStops("Arad", "Bucharest", stopProvinces, Algorithms.AStarSearch);
        graph.showSolution(n);
        graph.reset();
 }

}
