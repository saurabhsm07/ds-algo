package com.algorithims.searching;
/**
 * 
 * @author saurabh_mahambrey
 *Binary Search
Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
A simple approach is to do linear search.The time complexity of above algorithm is O(n). 
Another approach to perform the same task is using Binary Search.
Binary Search: Search a sorted array by repeatedly dividing the search interval in half. 
Begin with an interval covering the whole array. 
If the value of the search key is less than the item in the middle of the interval, 
narrow the interval to the lower half. Otherwise narrow it to the upper half.
 Repeatedly check until the value is found or the interval is empty.
 
 Algorithim:
 Compare x with the middle element.
If x matches with middle element, we return the mid index.
Else If x is greater than the mid element, 
then x can only lie in right half subarray after the mid element. 
So we recur for right half.
Else (x is smaller) recur for the left half.
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	private int arr[];
	public BinarySearch(int[] arr) {
		super();
		this.arr = arr;
		
		}
	
	
	public int binarySearchImpl(int[] arr,int val){
		
		int high =arr.length;
		int low =0;
		int mid =(high+low)/2;
		while(low<=high){
//			System.out.println(arr[mid]);
			if(arr[mid]==val){
				return mid;
			}
			else if(arr[mid]>val){
			     high=mid-1;
			     mid=(high+low)/2;
			}
			else{
				low=mid+1;
				mid=(high+low)/2;
			}
		}
		return -1;
	}
	
	public int binarySearchRecursive(int arr[],int low,int high,int data){
		if(low>=high)
			return -1;
		else{
			int mid=(low+high)/2;
//			System.out.println(arr[mid]);
			if(arr[mid]==data){
				return mid;
			}
			else if(arr[mid]<data){
				return binarySearchRecursive(arr, mid+1, high, data);
			}
			else{
				return binarySearchRecursive(arr, low, mid-1, data);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
BinarySearch obj = new BinarySearch(new int[] {-12, -1, 1, 2, 3, 5, 8, 66, 99});
int present=obj.binarySearchImpl(obj.arr,8);
if(present==-1){
	System.out.println("element is not present");
}
	else {
		System.out.println("element is present at = "+present);
	}

present=obj.binarySearchRecursive(obj.arr, 0, obj.arr.length, 66);
if(present==-1){
	System.out.println("element is not present");
}
	else {
		System.out.println("element is present at = "+present);
	}
	}
	

}
