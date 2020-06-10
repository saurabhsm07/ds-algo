package com.caseStudy.Implementations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author saurabh_mahambrey
 * 
 * prims algorithim for Adjecency list
 */
public class PrimsMST {
	
private graph graphObj;
class edge{
	int vertex,weight;
	public edge(int vertex,int weight) {
		// TODO Auto-generated constructor stub
	this.vertex=vertex;
	this.weight=weight;
	}
}

class graph{
	private int v;
	private LinkedList<edge> adj[];
	
	public graph(int v) {
		// TODO Auto-generated constructor stub
		 this.v =v;
		adj = new LinkedList[this.v];
		for (int i = 0; i < adj.length; i++) {
		adj[i]=new LinkedList<edge>();
	}
	}
}

public void createMST(graph graphObj,int v){
	class heapStruct implements Comparable<heapStruct>{
		int key,value,parent;
		
		public heapStruct(int key,int value) {
			// TODO Auto-generated constructor stub
		this.key=key;
		this.value=value;
		
		}


		public int compareTo(heapStruct obj) {
			// TODO Auto-generated method stub
			return this.value-obj.value;
		}
	}
	
 List<heapStruct> heap = new LinkedList<heapStruct>();
 heap.add(new heapStruct(0,0));
 for (int i = 1; i < v; i++) {
	heap.add(new heapStruct(i, Integer.MAX_VALUE));
}
 List<heapStruct> MST = new LinkedList<heapStruct>();


 while(heap.size()>0){
	 heapStruct obj = heap.get(0);
	 heap.remove(0);
 Iterator<edge> edgeItr = graphObj.adj[obj.key].iterator();
while (edgeItr.hasNext()) {
	edge obj1 =  edgeItr.next();
	for (heapStruct heapObj : heap) {
		if(heapObj.key==obj1.vertex)
		if(obj1.weight < heapObj.value){
			System.out.println("v= "+heapObj.key+" u= "+obj.parent+" w="+obj1.weight);
			heapObj.value=obj1.weight;
			heapObj.parent=obj.key;
		}
	}
	

}
 MST.add(obj);


 }
 Iterator<heapStruct> it = MST.iterator();
 while (it.hasNext()) {
	 heapStruct type = it.next();
	System.out.println(type.parent+" ----"+type.value+"---->"+type.key);
};
}





public  void createGraph(int v){
	graphObj = new graph(9);
	graphObj.adj[0].add(new edge(1,4));
	graphObj.adj[0].add(new edge(7,8));
	graphObj.adj[1].add(new edge(2,8));
	graphObj.adj[1].add(new edge(7,11));
	graphObj.adj[2].add(new edge(3,7));
	graphObj.adj[2].add(new edge(8,2));
	graphObj.adj[2].add(new edge(5,4));
	graphObj.adj[3].add(new edge(4,9));
	graphObj.adj[3].add(new edge(5,14));
	graphObj.adj[4].add(new edge(5,10));
	graphObj.adj[5].add(new edge(6,2));
	graphObj.adj[6].add(new edge(7,1));
	graphObj.adj[6].add(new edge(8,6));
	graphObj.adj[7].add(new edge(8,7));
	createMST(graphObj,9);
}

}
