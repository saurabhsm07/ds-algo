package com.structHeap;

import java.util.Arrays;
import java.util.Scanner;

/**Problem Statement :
 * Question: Write an efficient program for printing k largest elements in an array. 
 * Elements in array can be in any order.
   For example, 
     if given array is [1, 23, 12, 9, 30, 2, 50] and you are 
   asked for the largest 3 elements i.e., k = 3 then your program should print 
   50, 30 and 23.
 * 
 */

/**
 1) Build a Max Heap tree in O(n)
 2) Use Extract Max k times to get k maximum elements from the Max Heap O(klogn)
   Time complexity: O(n + klogn)
 */
public class KLargestElements {

	static class HeapStruct{
		int heap[];
		int size;
		int initial=0;
		public HeapStruct(int arr[]) {
			// TODO Auto-generated constructor stub
		heap= new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			this.heap[i]=arr[i];
		}
		this.size=arr.length;
		}
		
		public void maxHeapify(int i){
			int largest =i,lChild=2*i+1-initial,rChild=2*i+2-initial;
//			System.out.println(heap[i]+" p");
//			if(lChild<heap.length)
//				System.out.print(heap[lChild]+" l ");
//			
//			if(rChild<heap.length)
//				System.out.print(heap[rChild]+" r ");
//			
			
			if(lChild<heap.length && heap[largest]<heap[lChild]){
				
				largest =lChild;
			}
			if(rChild<heap.length && heap[largest]<heap[rChild]){
				
				largest =rChild;
			}
			
			if(largest!=i){
				
				swapElements(i, largest);
				maxHeapify(largest);
			}
		
		}
		
		public int nextMax(){
			int val = heap[initial];
			initial++;
//			System.out.println("\n initial="+heap[initial]);
//			System.out.println("last parent="+heap[(size+initial)/2-1]);
			for (int i = (size+initial)/2-1; i >=initial; i--) {
			
				maxHeapify(i);
			}
			return val;
		}

		protected void swapElements(int i, int largest) {
			heap[largest]=heap[largest]+heap[i];
			heap[i]=heap[largest]-heap[i];
			heap[largest]=heap[largest]-heap[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {90, 15, 10, 7, 11,66,4,11,1,12, 2, 7, 3,99,200,7,4,23};
		HeapStruct obj = new HeapStruct(arr);
          for (int i = obj.heap.length/2-1; i >= 0; i--) {
			obj.maxHeapify(i);
		}
      
          Arrays.sort(arr);
          for (int i = 0; i < arr.length; i++) {
			System.out.print("  "+arr[i]);
		}
	displayHeap(obj);
	
	System.out.println("\n enter no of elemenbts you want");
	Scanner scn = new Scanner(System.in);
	int c=scn.nextInt();
	
	for (int i = 0; i < c; i++) {
		System.out.println("\n max no :"+(i+1)+"= "+obj.nextMax());
//		System.out.println("new heap after removing "+i+"th element");
//		displayHeap(obj);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	displayHeap(obj);
	
	}

	protected static void displayHeap(HeapStruct obj) {
		System.out.println("\n heap structure");
		for (int i = obj.initial; i < obj.heap.length; i++) {
			System.out.print(" "+obj.heap[i]);
			
		}
		
		
	}
	
	

}
