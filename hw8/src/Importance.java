
//package graph_solution;

//import static graph_solution.Graph_Solution.dijkstrasAlgorithm;

import java.util.*;

/**
 * It is my class that collects the functions I use to perform the operations in
 * Part 3. It contains 3 methods. The main one of them is ImportanceSolution.
 * The ImportanceSolution method calls findShortestPaths. findShortestPaths
 * calls the dijkstrasAlgorithm method.
 * 
 * @author 1801042103
 *
 */
public class Importance {

	/**
	 * This method does the desired task in part3. By calling 1 helper method. This
	 * helper method allows me to find the shortest path
	 * 
	 * @param g          the graph
	 * @param importance importance integer array
	 * @return double array
	 */
	public double[] ImportanceSolution(Graph g, int[] importance) {
		double ret[] = new double[g.getNumV()];

		for (int i = 0; i < g.getNumV(); i++)
			ret[i] = 0;

		for (int v = 0; v < g.getNumV(); v++) {
			double cur = 0;
			for (int u = 0; u < g.getNumV(); u++) {
				if (u == v)
					continue;
				int[] paths = new int[g.getNumV()];
				int[] pathsUsingR = new int[g.getNumV()];
				findShortestPaths(g, u, v, g.getNumV(), paths, pathsUsingR);
				for (int w = 0; w < g.getNumV(); w++) {
					if (w == u || w == v || paths[w] == 0)
						continue;
					cur += pathsUsingR[w] / paths[w];
				}
			}
			ret[v] = cur;
		}

		return ret;
	}

	/**
	 * This method implement dijkstarasAlgorithm according to my needs.
	 * 
	 * @param graph       the graph
	 * @param start       the source vertex
	 * @param dist        the distances array
	 * @param pathsUsingR the number of shortest paths array using vertex r
	 * @param paths       the number of shortest paths array
	 * @param par         the parents array
	 * @param r           is the vertex that need to check the shortest paths using
	 *                    it
	 */
	public void dijkstrasAlgorithm(Graph graph, int start, int[] paths, int[] pathsUsingR, int r, int[] par,
			double[] dist) {
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
					operatorResult = dist[u] + weight;
					if (operatorResult < dist[v]) {
						dist[v] = operatorResult;
						if (u == r || par[u] == r)
							par[v] = r;
					} else if (dist[v] == dist[u] + weight && par[u] == r) {
						pathsUsingR[v]++;
					} else if (dist[v] == dist[u] + weight) {
						paths[v]++;
					}
				}
			}
		}
	}

	/**
	 * This method provide find the shortest path
	 * 
	 * @param             g, the graph to calculate the number of shortest paths
	 * @param             s, the starting vertex
	 * @param             r, the vertex to count shortest pathes through it
	 * @param             n, the number of vertices
	 * @param paths       the number of paths array
	 * @param pathsUsingR the number of paths using vertex r
	 */
	private void findShortestPaths(Graph g, int s, int r, int n, int[] paths, int[] pathsUsingR) {
		double[] dist = new double[n];
		int[] par = new int[n];

		for (int i = 0; i < n; i++)
			dist[i] = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			paths[i] = 0;
			par[i] = -1;
			pathsUsingR[i] = 0;
		}

		dijkstrasAlgorithm(g, s, paths, pathsUsingR, r, par, dist);
	}

}
