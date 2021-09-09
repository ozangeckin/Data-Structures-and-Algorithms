//package graph_solution;

import java.util.*;

/** Class to implement the breadth-first search algorithm.
 *  @author Koffman and Wolfgang
 * */

public class BreadthFirstSearch {

      // Data Fields
  /** A reference to the graph being searched. */
  private Graph graph;

  /** Array of parents in the depth-first search tree. */
  private int[] parent;

  /** Flag to indicate whether this vertex has been visited. */
  private boolean[] identified;

  // Constructors
  /** Construct the breadth-first search of a Graph
      starting at vertex 0 and visiting the start vertices in
      ascending order.
      @param graph The graph
   */
  public BreadthFirstSearch(Graph graph) {
    this.graph = graph;
    int n = graph.getNumV();
    parent = new int[n];
    identified = new boolean[n];
    for (int i = 0; i < n; i++) {
      parent[i] = -1;
    }
  }
    
  /** Perform a breadth-first search of a graph.
      post: The array parent will contain the predecessor
            of each vertex in the breadth-first
            search tree.
      @param graph The graph to be searched
      @param start The start vertex
      @return The array of parents
   */
  public int[] breadthFirstSearch(int start) {
    Queue < Integer > theQueue = new LinkedList < Integer > ();
    /* Mark the start vertex as identified and insert it
       into the queue */
    identified[start] = true;
    theQueue.offer(start);
    /* While the queue is not empty */
    while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
      int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
      Iterator < Edge > itr = graph.edgeIterator(current);
      while (itr.hasNext()) {
        Edge edge = itr.next();
        int neighbor = edge.getDest();
        // If neighbor has not been identified
        if (!identified[neighbor]) {
          // Mark it identified.
          identified[neighbor] = true;
          // Place it into the queue.
          theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
          parent[neighbor] = current;
        }
      }
      // Finished visiting current.
    }
    return parent;
  }
  
   /** Check if a vertex is visited or not
   * @param node, the vertex to check
      @return true if it's visited or not otherwise
   */  
  public boolean isVisited(int node){
      return identified[node];
  }
}
