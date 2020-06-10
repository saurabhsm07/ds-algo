package com.structGraph;

import com.structures.Graph;

import java.util.ListIterator;
import java.util.Stack;

/**
 * 
 * @author saurabh_mahambrey
 *theory :
 *Topological sorting for Directed Acyclic Graph (DAG) is a 
 *linear ordering of vertices such that for every directed edge uv, 
 *vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 * 
 * algorithim :
 * In topological sorting, we use a temporary stack. 
 * We don�t print the vertex immediately, 
 * we first recursively call topological sorting for all its adjacent vertices, 
 * then push it to a stack. Finally, print contents of stack. 
 * Note that a vertex is pushed to stack only when all of its adjacent 
 * vertices (and their adjacent vertices and so on) are already in stack.
 */

public class GraphTpSort {
	
	
public void performTopologicalSort(Graph graph){
	System.out.println("The Topological order of the given DAG is :");
	Stack<Integer> stack = new Stack<Integer>();
	for (int i = 0; i < graph.vertices; i++) {
		
		ListIterator<Integer> itr = graph.adjList[i].listIterator();
		while (itr.hasNext()) {
			getTopologicalOrder(graph,itr.next(),stack);
			
		}
		if(!stack.contains(i)){
			stack.push(i);
		}
		
	}
	
	
		while (!stack.empty()) {
			System.out.print(stack.pop()+",");
		
	}
}
	
	private void getTopologicalOrder(Graph graph,Integer node, Stack<Integer> stack) {
	// TODO Auto-generated method stub
	ListIterator<Integer> itr = graph.adjList[node].listIterator();
	while (itr.hasNext()) {
	getTopologicalOrder(graph, itr.next(), stack);	
	}
	if(!stack.contains(node)){
		System.out.println("adding node="+node);
		stack.push(node);
	}
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Graph graph = new Graph(6);
	        
	
	        graph.addDirectedEdge(5, 2);
	        graph.addDirectedEdge(5, 0);
	        graph.addDirectedEdge(4, 0);
	        graph.addDirectedEdge(4, 1);
	        graph.addDirectedEdge(2, 3);
	        graph.addDirectedEdge(3, 1);
	        
	        graph.printGraph();
	        
	        new GraphTpSort().performTopologicalSort(graph);
	}

}
