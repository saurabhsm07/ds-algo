package com.services;

import java.util.Arrays;


public class KrushalsMST {

	class  Edge implements Comparable<Edge>{
		int src,dest,weight;

		@Override
		public int compareTo(Edge compareEdge) {
			// TODO Auto-generated method stub
			return this.weight-compareEdge.weight;
		}
		
	}
	
	class Subset{
		int parent,rank;
	
	}
	int V,E;
	Edge edges[];
	
	public KrushalsMST(int v,int e) {
		// TODO Auto-generated constructor stub
		V=v;E=e;
		edges = new Edge[e];
	for (int i = 0; i < edges.length; i++) {
		edges[i]=new Edge();
	}
	}
	
	public KrushalsMST() {
		// TODO Auto-generated constructor stub
	}

	int find(Subset subset[],int i){
		if(subset[i].parent!=i)
		return subset[i].parent = find(subset,subset[i].parent);
		return subset[i].parent;
	}
	
	void union(Subset subset[],int x,int y){
//		int xroot = find(subset,x);
//		int yroot = find(subset,y);
		int xroot = x;
		int yroot = y;
		if(subset[xroot].rank < subset[yroot].rank)
			subset[xroot].parent=yroot;
		else if(subset[yroot].rank<subset[xroot].rank)
			subset[yroot].parent = xroot;
		else
		{
			subset[xroot].parent=yroot;
			subset[xroot].rank++;
		}
	}

	public  void mstCreate() {
		Edge[] resultTree = new Edge[V];
		
		for (int i = 0; i < resultTree.length; i++) {
			resultTree[i]=new Edge();
		}
		
		Arrays.sort(edges);
Subset subset[] = new Subset[V];
for (int i = 0; i < subset.length; i++) {
	subset[i] = new Subset();
	subset[i].parent = i;
	subset[i].rank=0;
}
		
int i=0;
int e=0;
while(e<V-1){
	Edge edge  = new Edge();
	edge = edges[i++];
	int x = find(subset,edge.src);
	int y = find(subset,edge.dest);
	if(x!=y){
		union(subset, edge.src, edge.dest);
		resultTree[e++]= edge;
	}
	
}

// print the contents of result[] to display the built MST
System.out.println("Following are the edges in the constructed MST");
for (i = 0; i < e; ++i)
    System.out.println(resultTree[i].src+" -- "+resultTree[i].dest+" == "+
    		resultTree[i].weight);


	}

	public  static void createKrushalMST(){
		 
		 
		        /* Let us create following weighted graph
		                 10
		            0--------1
		            |  \     |
		           6|   5\   |15
		            |      \ |
		            2--------3
		                4       */
		        int V = 4;  // Number of vertices in graph
		        int E = 5;  // Number of edges in graph
		        KrushalsMST graph = new KrushalsMST(V, E);
		 
		        // add edge 0-1
		        graph.edges[0].src = 0;
		        graph.edges[0].dest = 1;
		        graph.edges[0].weight = 10;
		 
		        // add edge 0-2
		        graph.edges[1].src = 0;
		        graph.edges[1].dest = 2;
		        graph.edges[1].weight = 6;
		 
		        // add edge 0-3
		        graph.edges[2].src = 0;
		        graph.edges[2].dest = 3;
		        graph.edges[2].weight = 5;
		 
		        // add edge 1-3
		        graph.edges[3].src = 1;
		        graph.edges[3].dest = 3;
		        graph.edges[3].weight = 15;
		 
		        // add edge 2-3
		        graph.edges[4].src = 2;
		        graph.edges[4].dest = 3;
		        graph.edges[4].weight = 4;
		 
		        graph.mstCreate();
		    }
		
	

}
