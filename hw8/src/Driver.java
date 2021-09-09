/**
 * This class Driver class testing methods and parts.
 * 
 * @author ozan.geckin
 *
 */
public class Driver {
	public static void main(String[] args) {
		Graph g = new ListGraph(4, false);
		Edge e0 = new Edge(0, 1, 1);
		Edge e1 = new Edge(0, 2, 5);
		Edge e2 = new Edge(1, 2, 3);
		Edge e3 = new Edge(1, 3, 5);
		Edge e4 = new Edge(2, 3, 2);
		g.insert(e0);
		g.insert(e1);
		g.insert(e2);
		g.insert(e3);
		g.insert(e4);

		GraphSolution graphSolution = new GraphSolution();

		// Dijkstra Part 1

		System.out.println("Here Is the results for part 1:");

		int pr[] = new int[10];
		double di[] = new double[10];
		// Addition, Multiplication, *
		graphSolution.dijkstrasAlgorithm(g, 0, pr, di, "Addition");
		System.out.println("The distances array using Addition operator is:");
		for (int i = 0; i <= 3; i++)
			System.out.println(di[i]);
		graphSolution.dijkstrasAlgorithm(g, 0, pr, di, "Multiplication");
		System.out.println("The distances array using Multiplication operator is:");
		for (int i = 0; i <= 3; i++)
			System.out.println(di[i]);
		graphSolution.dijkstrasAlgorithm(g, 0, pr, di, "*");
		System.out.println("The distances array using * operator is:");
		for (int i = 0; i <= 3; i++)
			System.out.println(di[i]);

		System.out.println("Here Is the results for part 2.i:");

		System.out.println("The number of components using DFS ->" + graphSolution.GetNumberOfComponentsDFS(g));
		System.out.println("The number of components using BFS ->" + graphSolution.GetNumberOfComponentsBFS(g));

		System.out.println("Here Is the results for part 2.ii:");
		graphSolution.measureTime(1000);
		graphSolution.measureTime(2000);
		graphSolution.measureTime(5000);
		graphSolution.measureTime(10000);

	}
//	    
}
