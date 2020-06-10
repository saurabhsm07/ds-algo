package com.services;

 public class UnionFind{
  public int verticesCount,edgesCount;
  public Edge edges[];
  public class Edge{
	  public int src,dest;
  }
  public UnionFind(int v,int e){
	verticesCount=v;
	edgesCount=e;
	edges = new Edge[e];
	for (int i = 0; i < edgesCount; i++) {
		 edges[i] = new Edge();
	}
  }
  
  public int find(int parent[],int i){
	  if(parent[i]==-1)
		  return i;
	  return find(parent,parent[i]);
	  
  }
  
  public void union(int parent[],int x,int y){
	 int xset = find(parent,x);
	 int yset = find(parent,y);
	 parent[xset]=yset;
  }
  
  public int checkCycle(UnionFind graph){
	  int parent[] = new int[graph.verticesCount];
	  for (int i = 0; i < parent.length; i++) {
		parent[i]=-1;
	}
	  for (int i = 0; i < graph.edgesCount; i++) {
		int x = find(parent,graph.edges[i].src);
		int y = find(parent,graph.edges[i].dest);
		if(x == y)
			return 1;
		
		union(parent, x, y);
	}
  return 0;
  }
  }
