package com.structGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

	static class Graph{
		private int vertices;
		private LinkedList<Integer>[] adjList;
		
	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		
		this.adjList = new LinkedList[vertices];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		// TODO Auto-generated constructor stub
	}
	

	
	}
	public static   void addEdge(Graph obj,int src,int dest){
		obj.adjList[src].add(dest);
	obj.adjList[dest].add(src);
}


public static void printGraph(Graph obj){
for (int i = 0; i < obj.vertices; i++) {
	System.out.println("Source :"+i);
	System.out.println("Edges :");
	for (Integer element : obj.adjList[i]) {
		System.out.print(element+"---->");
	}
System.out.print("End \n");
}

}

public void breathFirstSearch(Graph obj,int source){
 boolean visited[] = new boolean[obj.vertices];
 Queue<Integer> queue= new LinkedList<Integer>();
 for (int i = 0; i < visited.length; i++) {
	visited[i]=false;
}
 System.out.print(source+" ");
 visited[source]=true;
 
 Iterator<Integer> itr = obj.adjList[source].iterator();
 while (itr.hasNext()) {
	queue.add(itr.next()); 
	
}
 
while (!queue.isEmpty()) {
	int vertex=queue.poll();
	if(!visited[vertex]){
		visited[vertex]=true;
		System.out.print(vertex+" ");
		itr = obj.adjList[vertex].iterator(); 
		while (itr.hasNext()) {
				queue.add(itr.next()); 
				
			}
	}
		
}

}
public static void main(String[] args) {
	 
	        // create the graph given in above figure
//	        int V = 5;
//	        Graph graph = new Graph(V);
//	        addEdge(graph, 0, 1);
//	        addEdge(graph, 0, 4);
//	        addEdge(graph, 1, 2);
//	        addEdge(graph, 1, 3);
//	        addEdge(graph, 1, 4);
//	        addEdge(graph, 2, 3);
//	        addEdge(graph, 3, 4);
	      
	        Graph graph = new Graph(4);
	        
	        addEdge(graph,0, 1);
	        addEdge(graph,0, 2);
	        addEdge(graph,1, 2);
	        addEdge(graph,2, 0);
	        addEdge(graph,2, 3);
	        addEdge(graph,3, 3);
	        // print the adjacency list representation of 
	        // the above graph
	        printGraph(graph);
	        System.out.println("brs of the graph");
	        new GraphBFS().breathFirstSearch(graph, 2);
	    }
}

