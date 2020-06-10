package com.algorithims.sorting;

import com.utility.Utility;

/**
 * @author saurabh_mahambrey
 *Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, 
 *calls itself for the two halves and then merges the two sorted halves. 
 *The merge() function is used for merging two halves.
 * The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] 
 * are sorted and merges the two sorted sub-arrays into one.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r) 
             
 Time complexity of Merge Sort is \Theta(nLogn) 
 space complexity of merge sort = O(n);            
 */

public class MergeSort {

/**
 * @param arr - array to b merged
 * @param low - starting point of first half of array
 * @param middle - end point of first half of array
 * @param high - end point of second half of array
 */
public void merge(int arr[],int low,int middle,int high){
/**for merging walk through purpose------------------------------------------- */
//	System.out.println("merging stage--------");
//	System.out.println("initial="+l);
//	System.out.println("final="+r);

	System.out.println();
	int lengthOf1 = middle-low+1;
	int lengthOf2 = high-middle;
	
	int[] arr1 = new int[lengthOf1];
	int[] arr2 = new int[lengthOf2];
	
	
	for (int i = 0; i < lengthOf1; i++) {
	arr1[i] = arr[i+low]; 	
	}
	
	for (int i = 0; i < lengthOf2; i++) {
	arr2[i]	 = arr[i+middle+1];
	}
	
	// initial indexes of the sub array and the aray to b merged
	int i=0,j=0,k=low;
	
	while ( i < lengthOf1 && j< lengthOf2) {
		if(arr1[i]<=arr2[j]){
			arr[k] = arr1[i];
		i++;
		}
		else{
			arr[k]= arr2[j];
			j++;
		}
		k++;
	}
	
	while(i<lengthOf1){
	arr[k]	=arr1[i];
	i++;k++;
	}
	
	while(j<lengthOf2){
		arr[k]	=arr2[j];
			j++;k++;
		}
	/** to checl the state of array at each stage*/
//	Utility.printArray(arr);
}
	
public void sort(int arr[], int low,int high){
	System.out.println("splitting Stage----------------------------------------------");
	System.out.println("initial="+low);
	System.out.println("final="+high);
	if(low<high){
	int middle= (low+high)/2;	
	

	
	sort(arr,low,middle);
	sort(arr,middle+1,high);
		
	merge(arr, low, middle, high);
	}
	
}



public static void main(String[] args) {
	MergeSort obj = new MergeSort();
	int arr[] = new int[] {1,5,2,-1,-12,66,3,99,8};
	obj.sort(arr, 0, arr.length-1);
	Utility.printArray(arr);
}

}
