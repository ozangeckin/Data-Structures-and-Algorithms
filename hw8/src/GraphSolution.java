
//package graph_solution;

import java.util.HashSet;
import java.util.Random;

/**
 * This class needs to be able to perform the tasks in part 1 and part 2.
 * includes methods. The dijkstrasAlgorithm method for part 1. For Part 2,
 * GetNumberOfComponentsDFS, GetNumberOfComponentsBFS and measureTime.
 *
 * @author 1801042103
 *
 */
public class GraphSolution {

	/**
	 * This method returns the number of components in the graph DFS search it
	 * receives.
	 * 
	 * @param g, the graph to count the number of components on it
	 * @return the number of components
	 */
	public int GetNumberOfComponentsDFS(Graph g) {
		int ret = 0;
		DepthFirstSearch DFS = new DepthFirstSearch(g);
		for (int i = 0; i < g.getNumV(); i++) {
			if (!DFS.isVisited(i)) {
				DFS.depthFirstSearch(i);
				ret++;
			}
		}
		return ret;
	}

	/**
	 * This method returns the number of components in the graph BFS search it
	 * receives.
	 * 
	 * @param g, the graph to count the number of components on it
	 * @return the number of components
	 */
	public int GetNumberOfComponentsBFS(Graph g) {
		int ret = 0;
		BreadthFirstSearch BFS = new BreadthFirstSearch(g);
		for (int i = 0; i < g.getNumV(); i++) {
			if (!BFS.isVisited(i)) {
				BFS.breadthFirstSearch(i);
				ret++;
			}
		}
		return ret;
	}

	/**
	 * 
	 * This method part1 details in report.
	 * 
	 * @param graph, the graph to do the Dijkstra algorithm on it
	 * @param start, the starting vertex
	 * @param pred, the array to store the parent of each vertex
	 * @param dist, the array to store the distance for each vertex
	 * @param type, to choose the operator type whether it's addition,
	 *        multiplication or * operator
	 */
	public void dijkstrasAlgorithm(Graph graph, int start, int[] pred, double[] dist, String type) {
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		// Initialize vMinusS.
		for (int i = 0; i < numV; i++) {
			if (i != start) {
				vMinusS.add(i);
			}
		}
		// Initialize pred and dist.
		for (int v : vMinusS) {
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();
		}
		// Main loop
		while (vMinusS.size() != 0) {
			// Find the value u in vMinusS with the smallest dist[u].
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for (int v : vMinusS) {
				if (dist[v] < minDist) {
					minDist = dist[v];
					u = v;
				}
			}
			// Remove u from vMinusS.
			vMinusS.remove(u);
			// Update the distances.
			for (int v : vMinusS) {
				if (graph.isEdge(u, v)) {
					double weight = graph.getEdge(u, v).getWeight();
					double operatorResult = 0.0;
					if (type == "Multiplication")
						operatorResult = dist[u] * weight;
					else if (type == "*")
						operatorResult = dist[u] + weight - (dist[u] * weight);
					else
						operatorResult = dist[u] + weight;
					if (operatorResult < dist[v]) {
						dist[v] = operatorResult;
						pred[v] = u;
					}
				}
			}
		}
	}

	/**
	 * This method use part 2 details in report.
	 * 
	 * @param n the number of vertices
	 */

	public void measureTime(int n) {

		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			int edges = i * n - 7;
			Graph g = new ListGraph(n, false);

			for (int j = 0; j < edges; j++) {
				int u = random.nextInt(n);
				int v = random.nextInt(n);
				Edge e = new Edge(u, v);
				g.insert(e);
			}

			long startTime = System.nanoTime();

			GetNumberOfComponentsDFS(g);

			long estimatedTime = System.nanoTime() - startTime;

			double elapsedTimeInSecond = (double) estimatedTime / 1_000_000;

			System.out.println("Time to count the number of components for a graph of size " + n + " vertices and "
					+ edges + " edge using DFS is " + elapsedTimeInSecond);

			startTime = System.nanoTime();

			GetNumberOfComponentsBFS(g);

			estimatedTime = System.nanoTime() - startTime;

			elapsedTimeInSecond = (double) estimatedTime / 1_000_000;

			System.out.println("Time to count the number of components for a graph of size " + n + " vertices and "
					+ edges + " edge using BFS is " + elapsedTimeInSecond);
			System.out.println("---------------------------------");

		}
		System.out.println("-----------------------------------------------------------------");
	}
}
