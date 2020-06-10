package com.structures;

import java.util.LinkedList;

public class Graph {
public int vertices,weight;
public LinkedList<Integer> adjList[];
@SuppressWarnings("unchecked")
public Graph(int vertices) {
	// TODO Auto-generated constructor stub
this.vertices = vertices;
adjList = new LinkedList[vertices];
for (int i = 0; i < adjList.length; i++) {
	adjList[i]= new LinkedList<Integer>();
}
}

public void printGraph(){
	System.out.println("AdjList representation of the list is:");
	for (int i = 0; i < vertices; i++) {
		System.out.println("Edges for node:"+ i);
		System.out.print(i);
		for (int val:adjList[i]) {
			System.out.print("--->"+val);
		}
		System.out.println();
	}

}

public void addDirectedEdge(int src,int dest){
	adjList[src].add(dest);
}

public void addUndirectedEdge(int src,int dest){
	adjList[src].add(dest);
	adjList[dest].add(src);
}
}
