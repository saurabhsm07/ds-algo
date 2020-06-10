package com.algorithims.greedy;

import java.util.*;

/**
 * Created by saurabh_mahambrey on 1/29/2019.
 */
public class DijkstraSPA {

public int[][] vertices;
    int size;
static class Edge{
   int vertex,weight;

    public Edge(int vertex,int weight) {
        this.vertex = vertex;
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex=" + vertex +
                ", weight=" + weight +
                '}';
    }
}

static class Graph{
    int vertices;
    List<Edge> adjList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int i=0;i<vertices;i++){
            this.adjList[i]=new LinkedList<Edge>();
        }
    }

    protected  void addEdge(int src,int dest,int weight){
        adjList[src].add(new Edge(dest,weight));
        adjList[dest].add(new Edge(src, weight));
    }
}


    protected void shortestPathAdjList(Graph adjGraph){
        vertices = new int[adjGraph.vertices][2];
        size=adjGraph.vertices;
        int shortestDistance[] = new int[adjGraph.vertices];
        vertices[0][0]=0;
        vertices[0][1]=0;
        shortestDistance[0]=0;
        for (int i=1;i<vertices.length;i++){
            vertices[i][1]=10000;
            vertices[i][0]=i;
            shortestDistance[i]=10000;
        }
        printVertices();
        minHeapify();
        int ele = extractMin();
        while(size>0) {

            System.out.println("ele = " + ele);
            List<Edge> edges = adjGraph.adjList[ele];
            for (Edge ed :edges) {
                int min =shortestDistance[ed.vertex];
                    shortestDistance[ed.vertex] = Math.min(shortestDistance[ed.vertex], shortestDistance[ele] + ed.weight);
                if(min!=shortestDistance[ed.vertex]) {
                    updateVertices(ed.vertex,min,shortestDistance[ed.vertex],0);
                    minHeapify();
                }
            }
            printVertices();
            ele=extractMin();
        }

        System.out.println("shortest distance tree :");
        for (int i=0;i<shortestDistance.length;i++){
            System.out.println(" i= "+i+" dist= "+shortestDistance[i]);
        }
    }

    public int getVertices(int vertex){
        for (int i=0;i<vertices.length;i++){
            if(vertices[i][0]==vertex)
                return vertices[i][1];
        }
        return Integer.MAX_VALUE;
    }
    private boolean updateVertices(int vertex,int oldWeight,int newWeight,int pos) {
        if(vertices[pos][0]==vertex)
            vertices[pos][1]=newWeight;
        if(oldWeight>=vertices[pos][1] && pos*2+1 < size){
            boolean state=updateVertices(vertex,oldWeight,newWeight,pos*2+1);
            if(!state && pos*2+2 < size)
                updateVertices(vertex,oldWeight,newWeight,pos*2+2);
        }
        else
            return false;

        return false;
    }

    private void printVertices() {
        for (int i=0;i<vertices.length;i++){
            System.out.println(vertices[i][0]+"  -  "+vertices[i][1]);
        }
    }


    protected void printGraph(Graph graph){
        for (int i=0;i<graph.vertices;i++){
            System.out.println("branches of = "+i);
            List<Edge> edges=graph.adjList[i];
            for(Edge ed : edges){
                System.out.println(ed);
            }
        }
    }


    private int extractMin() {

        if(vertices[0][1]==Integer.MAX_VALUE){
            return  -1;
        }
        else {
            int ele = vertices[0][0];
            for (int i = 1; i < size; i++) {
                vertices[i - 1][0] = vertices[i][0];
                vertices[i - 1][1] = vertices[i][1];
            }
            size--;
            minHeapify();
            return ele;
        }

    }

    private void minHeapify() {
        for(int i=size/2-1;i>=0;i--){
            minHeap(i);
        }

    }

    private void minHeap(int pos) {
        int min=pos;
        int left=2*pos+1;
        int right=2*pos+2;
        if(left<vertices.length && vertices[min][1]>vertices[left][1]){
            min=left;
        }
        if(right<vertices.length && vertices[min][1]>vertices[right][1]){
            min=right;
        }
        if(min!=pos){
            swapHeapNodes(vertices,min,pos);
            minHeap(min);
        }


    }

    private static void swapHeapNodes(int[][] vertices, int min, int pos) {
        int tempMin=vertices[min][0];
        int tempVal=vertices[min][1];

        vertices[min][0]=vertices[pos][0];
        vertices[min][1]=vertices[pos][1];
        vertices[pos][0]=tempMin;
        vertices[pos][1]=tempVal;
    }

    protected  void shortestPathMatrix(int[][] graph){
       int verticeDistance[] = new int[graph.length];
       boolean visitedSet[] = new boolean[graph.length];
       // initialize initial distance to infinity
       verticeDistance[0]=0;
       visitedSet[0]=false;
       for (int i=1;i<verticeDistance.length;i++){
           verticeDistance[i]=Integer.MAX_VALUE;
           visitedSet[i]=false;
       }

       for (int ele=0;ele!=Integer.MAX_VALUE;ele=getVertex(visitedSet,verticeDistance)){
           visitedSet[ele]=true;
           for (int i=0;i<graph[ele].length;i++){
               if(graph[ele][i] !=0){
                   verticeDistance[i]=Math.min(verticeDistance[i],verticeDistance[ele]+graph[ele][i]);
               }
           }
           System.out.println("Distances for ele = "+ele);
           for (int i=0;i<verticeDistance.length;i++){
               System.out.println(i+" = "+verticeDistance[i]);
           }
       }

       System.out.println("Final Result");
       for (int i=0;i<verticeDistance.length;i++){
           System.out.println(i+" = "+verticeDistance[i]);
       }




   }

    private int getVertex(boolean[] visitedSet, int[] verticeDistance) {
        int min=Integer.MAX_VALUE;
        int pos=Integer.MAX_VALUE;
        for (int i=0;i<visitedSet.length;i++){
            if(min>verticeDistance[i] && visitedSet[i]==false){
               pos=i;
                min=verticeDistance[i];
            }
        }
        return pos;
    }



    public static void main(String[] args) {

        //arg for the creating adj list
        DijkstraSPA obj = new DijkstraSPA();



//        testShortestPathInGraphMatrixRepresentation(obj);

        testShortestPathGraphAdjListRepresentation(obj);



    }

    private static void testShortestPathGraphAdjListRepresentation(DijkstraSPA obj) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
        obj.printGraph(graph);
        obj.shortestPathAdjList(graph);
    }

    private static void testShortestPathInGraphMatrixRepresentation(DijkstraSPA obj) {
        int[][] graphMatrixRepresentation = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        obj.shortestPathMatrix(graphMatrixRepresentation);
    }
}
