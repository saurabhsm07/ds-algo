package com.algorithims.sorting;

import com.utility.Utility;

/**
 * 
 * @author saurabh_mahambrey
 *SELECTION SORT:
 *The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) 
from the unsorted subarray is picked and moved to the sorted subarray.

Following example explains the above steps:

arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	int arr[];
	public SelectionSort(int[] arr) {
		super();
		this.arr = arr;
	}
	
	public void selectionSortImpl(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			int smallest=i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[smallest]>arr[j]){
					Utility.swapElements(arr, smallest, j);
				}
				System.out.println("itr : "+i+" pass : "+j);
				Utility.printArray(arr);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
SelectionSort obj = new SelectionSort(new int[]{1,5,2,-1,-12,66,3,99,8});
obj.selectionSortImpl(obj.arr);
Utility.printArray(obj.arr);
	}

	

}
