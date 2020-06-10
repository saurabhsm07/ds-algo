package com.structHeap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author saurabh_mahambrey
 * 
 *         problem statement: Given an n x n matrix, where every row and column
 *         is sorted in non-decreasing order. Print all elements of matrix in
 *         sorted order.
 * 
 *         Example:
 * 
 *         Input: mat[][] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37,
 *         48}, {32, 33, 39, 50}, };
 * 
 *         Output: Elements of matrix in sorted order 10 15 20 25 27 29 30 32 33
 *         35 37 39 40 45 48 50
 *         
 *         
 */
public class PrintAllSortedElementsMatrix {

	static class Heap {
		int heapArr[][];
int totalElements;
int initial=0;
		public Heap(int heapArr[][]) {
			this.totalElements=0;
			// TODO Auto-generated constructor stub
			this.heapArr = Arrays.copyOf(heapArr, heapArr.length);
			 for (int i = 0; i < heapArr.length; i++) {
			
			 this.totalElements+=heapArr[i].length;
			 
			 }

		}

		
		/**
		 * 
		 * @param pos : root node to hipify on a 2D array
		 * 
		 * 
		 */
		public void minHeapify(int pos) {
			int smallestPos =pos;
int smallest = getPosition(pos),lChild=(2*pos+1-initial),rChild=(2*pos+2-initial);
if(2*pos+2<totalElements)
//System.out.println(" smallest="+smallest+" l="+getPosition(lChild)+" r="+getPosition(rChild));
if((2*pos+1-initial<totalElements)&&(smallest>getPosition(lChild))){
	smallestPos=lChild;
}
if((2*pos+2-initial<totalElements)&&(smallest>getPosition(rChild))){
	smallestPos=rChild;
}
if(smallestPos!=pos){
//System.out.println("swapping "+pos+" "+smallestPos+" "+initial+" "+lChild+"  "+rChild);
	
	swapElements(pos,smallestPos);
minHeapify(smallestPos);
}
		}

		protected void swapElements(int smallest,int source) {
			heapArr[smallest/4][smallest%4]=heapArr[smallest/4][smallest%4]+heapArr[source/4][source%4];
			heapArr[source/4][source%4]=heapArr[smallest/4][smallest%4]-heapArr[source/4][source%4];
			heapArr[smallest/4][smallest%4]=heapArr[smallest/4][smallest%4]-heapArr[source/4][source%4];
		}

		private  int getPosition(int i) {
			// TODO Auto-generated method stub
			if(i<totalElements)
			return heapArr[i/heapArr.length][i%heapArr.length];
			
			return 0;
		}
		
		private void setVal(int pos){
			heapArr[pos/heapArr.length][pos%heapArr.length]=100;
		}
/**
 * 
 * @param pos = root node removal
 * 
 */
		public void ExtractMin(int pos) {
			// TODO Auto-generated method stub
			initial++; //incremented everytime a min (root) is removed from the structure later used 
			
			System.out.print(" "+getPosition(pos));
			setVal(pos);
		      for (int i = (totalElements+pos)/2-1; i >=initial; i--) {
					
					minHeapify(i);
				}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] sortedMatrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		Heap obj = new Heap(sortedMatrix);

		System.out.println("initial arr");
		displayHeap(obj);
		System.out.println("level order");
		displayLevelOrder(obj);
		

		for (int i = obj.totalElements/2-1; i >=0; i--) {
//			System.out.println("parent  "+obj.getPosition(i)+" val "+i);
        obj.minHeapify(i);
		}
		
//		System.out.println("heapification result");
//		displayHeap(obj);
//		displayLevelOrder(obj);
	
	System.out.println("in complete sorted order");
	for (int i = 0; i < obj.totalElements; i++) {
		
		obj.ExtractMin(i);
//		displayHeap(obj);
//		displayLevelOrder(obj);
	}
	
	}

	protected static void displayHeap(Heap obj) {
		System.out.println();
		for (int i = 0; i < obj.heapArr.length; i++) {
			for (int j = 0; j < obj.heapArr[i].length; j++) {
				
				System.out.print(" "+obj.heapArr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void displayLevelOrder(Heap obj){
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		queue1.add(obj.initial);
	
		while (!queue1.isEmpty()) {
			
			System.out.println();
			queue2.addAll(queue1);
			System.out.println();
				while(!queue2.isEmpty()){
				int val =queue2.poll();
				queue1.poll();
				System.out.print(obj.getPosition(val)+" ");
				if(val*2+1-obj.initial<obj.totalElements)
			     queue1.add(val*2+1-obj.initial);
				if(val*2+2-obj.initial<obj.totalElements)
			    queue1.add(val*2+2-obj.initial);
				
			}
		}
	
		
		
		
	}

}
