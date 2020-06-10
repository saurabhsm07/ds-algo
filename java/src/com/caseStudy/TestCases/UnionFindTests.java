package com.caseStudy.TestCases;

import com.caseStudy.Implementations.PathCompressionQuickUnion;
import com.caseStudy.Interfaces.UnionFindInterface;

public class UnionFindTests {

	public static void main(String[] args) {
		
		
		int[][] testArray  = {{4,3},{3,8},{6,5},{9,4},{2,1},{8,9},{5,0},{7,2},{6,1},{1,0},{6,7}};
		
//		UnionFindInterface  ufObj  = new QuickFind(10);    //test quick find
//		UnionFindInterface  ufObj  = new QuickUnion(10);   //test union find
//		UnionFindInterface  ufObj  = new WeightedQuickUnion(10);   //test weighted union find
		UnionFindInterface ufObj  = new PathCompressionQuickUnion(10);
        UnionFind(testArray, ufObj);
     
	
	}

	public static void UnionFind(int[][] testArray, UnionFindInterface ufObj) {
		for (int i = 0; i < 10; i++) {
		       if(!ufObj.find(testArray[i][0],testArray[i][1])){
		    	   
		    	   ufObj.union(testArray[i][0],testArray[i][1]);
		    	   System.out.println("New Connection "+testArray[i][0]+"-------->"+testArray[i][1]);
		       }
		       else{
		    	   System.out.println("Already Connected "+testArray[i][0]+"-------->"+testArray[i][1]);
		       }
		
		}
		ufObj.getRunCount();
	}
}
