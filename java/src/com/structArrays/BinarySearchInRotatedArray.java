package com.structArrays;

/**
 * @author saurabh_mahambrey
 * problem statement :Search an element in a sorted and rotated array
 *An element in a sorted array can be found in O(log n) time via binary search. 
 *But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 *So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
 *Devise a way to find an element in the rotated array in O(log n) time.
 *
 *pivot : position/point till which the sorted array is rotated
 */
public class BinarySearchInRotatedArray {

	/**
	 * @param arr
	 * @param low
	 * @param high
	 * @param ele
	 * @return
	 * result of binary search after finding the pivot element.
	 */
	public int pivotBinarySearch(int arr[],int low,int high,int ele){
		int pivot =findPivot(arr, low, high);
		System.out.println(pivot);
    if (pivot==-1) {
    	return binarySearch(arr, low, high, ele);
		}
     if(ele==arr[pivot]){
    	return pivot;
    }
     if(arr[0]<=ele){
    	return binarySearch(arr, low, pivot-1, ele);
    }
    
    	return binarySearch(arr, pivot, high, ele);
	}
	
	public int findPivot(int arr[],int low,int high){
		int mid = (low+high)/2;
		if(high<low)
			return -1;
		if(high==low)
			return low;
		if (arr[mid]>arr[mid+1] && mid <high) {
			return mid;
		}
		if(arr[mid-1]>arr[mid]&& mid>low){
			return mid-1;
		}
		if(arr[low]>arr[mid]){
			return findPivot(arr, low,mid-1);
		}
		return findPivot(arr, mid, high);
	}
	public int binarySearch(int arr[],int low,int high,int ele){
		if (high < low) 
	           return -1; 
	             
	       int mid = (low + high)/2;   
	       if (ele == arr[mid]) 
	           return mid; 
	       if (ele > arr[mid]) 
	           return binarySearch(arr, (mid + 1), high, ele); 
	       return binarySearch(arr, low, (mid -1), ele); 
	}
	public static void main(String[] args) {
	BinarySearchInRotatedArray obj = new BinarySearchInRotatedArray();
	int arr[] = new int[] {5, 6, 7, 8, 9, 10, 11, 2, 3};
	System.out.println(obj.pivotBinarySearch(arr, 0,arr.length,3));
}
}
