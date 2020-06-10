package com.algorithims.sorting;

import com.utility.Utility;

/**
 * 
 * @author saurabh_mahambrey
 *Bubble Sort
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping 
the adjacent elements if they are in wrong order.

Example:
First Pass:
( 5 1 4 2 8 ) �> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) �>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) �>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) �> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), 
algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) �> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) �> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) �> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) �>  ( 1 2 4 5 8 )
Now, the array is already sorted, but our algorithm does not know if it is completed. 
The algorithm needs one whole pass without any swap to know it is sorted.

Third Pass:
( 1 2 4 5 8 ) �> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) �> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) �> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) �> ( 1 2 4 5 8 )
 */
public class BubbleSort {
int[] arr;

public BubbleSort(int[] arr) {
	super();
	this.arr = arr;
}

public void bubbleSortImpl(int[] arr){
	for (int i = 0; i < arr.length-1; i++) {
		
		for (int j = 0; j < arr.length-i-1; j++) {
			if(arr[j]>arr[j+1]){
				Utility.swapElements(arr, j+1, j);
			}
			System.out.println("itr : "+i+" pass : "+j);
			Utility.printArray(arr);
		}
	}
	
}


public void bubbleSortRec(int[] arr,int n){
    // Base case
    if (n == 1)
        return;
  
    // One pass of bubble sort. After
    // this pass, the largest element
    // is moved (or bubbled) to end.
    for (int i=0; i<n-1; i++)
        if (arr[i] > arr[i+1])
        {
            // swap arr[i], arr[i+1]
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
  
    // Largest element is fixed,
    // recur for remaining array
    bubbleSortRec(arr, n-1);
}
	


public static void main(String[] args) {
	BubbleSort obj = new BubbleSort(new int[] {1,5,2,-1,-12,66,3,99,8});
//	obj.bubbleSortImpl(obj.arr);
//	Utility.printArray(obj.arr);
	obj.bubbleSortRec(obj.arr,obj.arr.length);
	Utility.printArray(obj.arr);
}
}
