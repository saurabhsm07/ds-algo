package com.structGraph;

import java.util.LinkedList;
import java.util.Stack;
/**
 * 
 * @author saurabh_mahambrey
 * 
 *Theory :
 *
 *The longest path problem for a general graph is not as easy as the shortest
 * path problem because the longest path problem 
 *doesn�t have optimal substructure property. In fact, the Longest Path problem is 
 *NP-Hard for a general graph. However, the longest path problem has a linear 
 *time solution for directed acyclic graphs. 
 *
 *The idea is similar to linear time solution for shortest path in a 
 *directed acyclic graph., we use Topological Sorting.We initialize distances to all 
 *vertices as minus infinite and distance to source as 0, then we find a topological 
 *sorting of the graph. Topological Sorting of a graph represents a linear ordering of 
 *the graph (See below, figure (b) is a linear representation of figure (a) ). 
 *Once we have topological order (or linear representation), we one by one process 
 *all vertices in topological order.
 *
 *Algorithim:
 *
 *Following is complete algorithm for finding longest distances.
1) Initialize dist[] = {NINF, NINF, �.} and dist[s] = 0 where s is the source vertex. Here NINF means negative infinite.
2) Create a toplogical order of all vertices.
3) Do following for every vertex u in topological order.
���..Do following for every adjacent vertex v of u
������if (dist[v] < dist[u] + weight(u, v))
���������dist[v] = dist[u] + weight(u, v)
 */
public class GraphLongestpath {
	
	static class Edge{
	int vertex,weight;
	public Edge(int vertex,int weight) {
		// TODO Auto-generated constructor stub
	this.vertex=vertex;
	this.weight=weight;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
		
			return "[Wt="+weight+",dest="+vertex+"]";
		}
	}
	
	static class Graph{
		int  vertices;
		LinkedList<Edge> adjList[];
		public Graph(int vertices) {
			// TODO Auto-generated constructor stub
		this.vertices=vertices;
		this.adjList= new LinkedList[vertices];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Edge>();
		}
		}
		
		public void addEdge(int s,int d,int wt){
			adjList[s].add(new Edge(d, wt));
		}
	
		public void displayGraph(){
			for (int i = 0; i < vertices; i++) {
			
			for (Edge edge : adjList[i]) {
				System.out.print(i+"----->"+edge+",");
			}
			System.out.println();
			}
		}
		
	
	
	}
	/**
	 * @param args
	 */
	
	public static Stack<Integer> topologicalSortofGraph(Graph g){
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < g.vertices; i++) {
			for (Edge edge : g.adjList[i]) {
				stack=tpSort(g,edge.vertex,stack);
			}
			if(!stack.contains(i)){
				stack.add(i);
			}
		}
		System.out.println("topological Sort results in:");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+",");
			
		}
		System.out.println();
		return stack;
	}
	
	private static Stack<Integer> tpSort(Graph g,int vertex, Stack<Integer> stack) {

		// TODO Auto-generated method stub
		for (Edge edge : g.adjList[vertex]) {
		
			tpSort(g, edge.vertex, stack);	
		}
		
	return stack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
       
        g.displayGraph();
 
        findLongestDistance(topologicalSortofGraph(g),g,1);
	}

	private static void findLongestDistance(
			Stack<Integer> stackTp,Graph g,int source) {
		// TODO Auto-generated method stub
		int distance[] = new int[g.vertices];
		distance[source]=0;
	for (int i = 0; i < distance.length; i++) {
		if (i!=source) {
			distance[i]=-Integer.MAX_VALUE;
		}
		
	}
	for (int i = 0; i < g.vertices; i++) {
		for (Edge edge : g.adjList[i]) {
			if(distance[edge.vertex]<edge.weight+distance[i]){
				distance[edge.vertex]=edge.weight+distance[i];
			}
		}
	}
	System.out.println("longest distance to all the other nodes from source node is:");
	for (int i = 0; i < distance.length; i++) {
		if(distance[i]==-Integer.MAX_VALUE){
			System.out.println("source -->"+i+"= NO Path");
		}
		else
		System.out.println("source -->"+i+"="+distance[i]);
	}
	}

}
