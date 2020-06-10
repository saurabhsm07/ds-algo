package com.structGraph;

import java.util.LinkedList;

public class GraphDFS {

	static class Graph {
		int vertices;
		LinkedList<Integer> adjList[];

		@SuppressWarnings("unchecked")
		public Graph(int vertices) {
			// TODO Auto-generated constructor stub
			this.vertices = vertices;
			this.adjList = new LinkedList[vertices];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int src, int dest) {
			adjList[src].add(dest);
			adjList[dest].add(src);
		}

		public void printGraph(Graph obj) {
			for (int i = 0; i < obj.vertices; i++) {
				System.out.println("Source :" + i);
				System.out.println("Edges :");
				for (Integer element : obj.adjList[i]) {
					System.out.print(element + "---->");
				}
			}

		}
	}

	public void dfsTraversal(Graph obj, int vertex) {
		boolean visited[] = new boolean[obj.vertices];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		System.out.print(vertex + " ");
		visited[vertex] = true;
		while (obj.adjList[vertex].size() != 0) {
			int ele = obj.adjList[vertex].removeFirst();
			dfsUtil(obj, ele, visited);
		}

	}

	private void dfsUtil(Graph obj, int ele, boolean[] visited) {
		// TODO Auto-generated method stub
		if (!visited[ele]) {
			System.out.print(ele + " ");
			visited[ele] = true;
			while (obj.adjList[ele].size() != 0) {
				dfsUtil(obj, obj.adjList[ele].removeFirst(), visited);
			}
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal "
				+ "(starting from vertex 2)");

		new GraphDFS().dfsTraversal(g, 2);
	}
}
