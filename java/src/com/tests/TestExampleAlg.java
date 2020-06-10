package com.tests;

import com.caseStudy.Implementations.HuffmannCoding;
import com.caseStudy.Implementations.PrimsMST;
import com.services.ActivitySelection;
import com.services.KrushalsMST;
import com.services.UnionFind;

public class TestExampleAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


//		test activity selection-----------------------3
//		testActivitySelection();

	//test union find ---------------------------4
//		testUnionFind();

//		 testing krushals MST-------------------5
//		testKurshalsMST();

	//testing HuffMann coding------------------6
//		testHuffmannCoding();

//		testing PrimsMST--------------7
		testPrimsMST();
	}
	private static void testPrimsMST() {
		// TODO Auto-generated method stub
		PrimsMST prims = new PrimsMST();

		prims.createGraph(8);
	}


	public static void testActivitySelection(){
	int[] start = {1, 3, 0, 5, 8, 5};
    int[] finish ={2, 4, 6, 7, 9, 9};
    int totalActivities = 4;
	ActivitySelection acObj = new ActivitySelection();
	acObj.SelectActivities(start, finish, totalActivities);

	}

	public static void testUnionFind(){
		/* Let us create following graph
        0
       |  \
       |    \
       1-----2 */


		int V = 3, E = 3;

		UnionFind graph = new UnionFind(V,E);

       // add edge 0-1
     graph.edges[0].src = 0;
       graph.edges[0].dest = 1;

       // add edge 1-2
       graph.edges[1].src = 1;
       graph.edges[1].dest = 2;

       // add edge 0-2
       graph.edges[2].src = 0;
       graph.edges[2].dest = 2;

       if (graph.checkCycle(graph)==1)
           System.out.println( "graph contains cycle" );
       else
           System.out.println( "graph doesn't contain cycle" );

	}


public static void testKurshalsMST(){

	KrushalsMST.createKrushalMST();
}

public static void testHuffmannCoding(){
	char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
    int freq[] = { 5, 9, 12, 13, 16, 45 };
    HuffmannCoding huffObj = new HuffmannCoding();
    huffObj.createHuffmannCodes(arr, freq);
}

}
