package com.algorithims.sorting;

import com.utility.Utility;
/**
 * 
 * @author saurabh_mahambrey
 *QuickSort is a Divide and Conquer algorithm. 
 *It picks an element as pivot and partitions the given array around the picked pivot.
 *The key process in quickSort is partition(). Target of partitions is, 
 *given an array and an element x of array as pivot,
 * put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, 
 *and put all greater elements (greater than x) after x. 
 *All this should be done in linear time.
 *
 *Pseudo Code for recursive QuickSort function :

* low  --> Starting index,  high  --> Ending index *
quickSort(arr[], low, high)
{
    if (low < high)
    {
        / pi is partitioning index, arr[pi] is now
           at right place /
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}

Pseudo code for partition()

* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot /
partition (arr[], low, high)
{
    // pivot (Element to be placed at right position)
    pivot = arr[high];  
 
    i = (low - 1)  // Index of smaller element

    for (j = low; j <= high- 1; j++)
    {
        // If current element is smaller than or
        // equal to pivot
        if (arr[j] <= pivot)
        {
            i++;    // increment index of smaller element
            swap arr[i] and arr[j]
        }
    }
    swap arr[i + 1] and arr[high])
    return (i + 1)
}

performance analysis:
 worst case  is \theta(n^2).
best case theta(nLogn)
avg case Solution of above recurrence is also O(nLogn)
 */
public class QuickSort {
//the sort function
	
public void  sort(int[] array,int low,int high){
	
	if(low<high){
		int pi = partition(array,low,high);
		sort(array,low,pi-1);
		sort(array,pi+1,high);
	}
}

public int partition(int[] arr,int low,int high){
int pivot = arr[high];
int j=low-1;

for (int i = low; i < high; i++) {
	if(arr[i]<=pivot){
		
		++j;
		
		if(i!=j){
//			System.out.println("swap "+arr[j]+" and "+arr[i]);
			Utility.swapElements(arr, j, i);
		}
	
	}

}
Utility.swapElements(arr, j+1,high);
	return j+1;
}
public static void main(String[] args) {
	QuickSort obj = new QuickSort();
	int[] arr={1,22,221,5,55,40,42,33,1,2,2323,1,23,44};
	obj.sort(arr, 0, arr.length-1);

	Utility.printArray(arr);
}
}
