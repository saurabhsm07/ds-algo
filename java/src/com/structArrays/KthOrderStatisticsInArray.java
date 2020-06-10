package com.structArrays;

import com.utility.Utility;

import java.util.ArrayList;
import java.util.List;
/**
 * PROBLEM STATEMENT  1: K’th Smallest Element in Unsorted Array
 * Given an array and a number k where k is smaller than size of array,
 * we need to find the k’th smallest element in the given array.
 *
 * SOLUTION :
 * STEP 1 :CREATE A MAX HEAP OF FIRST K ELEMENTS OF THE ARRAY
 * STEP 2 :COMPARE THE REMAINING K+1 ELEMENTS WITH THE ROOT OF THE MAX HEAP
 *          STEP 3A : IF ELEMENT IS SMALLER THAN SWAP WITH ROOT AND MAX HEAP THE ROOT
 *          STEP 3B : IF NOT THAN MOVE TO NEXT ELEMENT
 * STEP 4: RETURN ROOT OF THE MAX HEAP AS THE RESULT
 *
 * IDEOLOGY : The Kth smallest elemnt is the largest among the k smallest elements of the array size n
 * (hence root of the max heap of size k among the input array elements)
 *
 * PROBLEM STATEMENT 2:
 * Given an array of integers. Write a program to find the
 * K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.
 */
public class KthOrderStatisticsInArray {

	/**
	 * @param args
	 */
	public int arr[];

	/**
	 * PROBLEM STATEMENT  1 : solution
	 * @param k
	 * @return
	 */
	private int findKthSmallest(int k){
		for (int i = 0; i < k; i++) {

			maxHeapify(i);
		}
		
	    for (int i = k; i < arr.length; i++) {
		if(arr[i]<arr[0]){
			arr= Utility.swapElements(arr,i,0);
			maxHeapify(0);
		}
	    }

	    return arr[0];
	}

	private int findKthLargestSumContiguousSubarray(int k){
		List<Integer> sumList=new ArrayList<Integer>();
		for (int i=0;i<arr.length;i++){
			int sum=0;
			for (int j=i;j<arr.length;j++){
				sum+=arr[j];
				sumList.add(i+j,sum);
			}
		}

		for (int i=0;i<k;i++){

			minHeapify(sumList,i);
		}

	    for(int i=k;i<sumList.size();i++){
	    	if(sumList.get(k)<sumList.get(0)){
	    		swapElementsInList(sumList,0,i);
	    		minHeapify(sumList,0);
			}
		}
	return sumList.get(0);
	}



	private void minHeapify(List<Integer> sumList, int i) {
		int smallest=i;
	if(i*2+1<sumList.size() && sumList.get(i*2+1)<sumList.get(smallest)){
		smallest=2*i+1;
	}
	if(i*2+2<sumList.size() && sumList.get(i*2+2)<sumList.get(smallest)){
		smallest=2*i+2;
	}
	if(smallest!=i){
		swapElementsInList(sumList, i, smallest);
		minHeapify(sumList,(i-1)/2);
	}
	}

	private void swapElementsInList(List<Integer> sumList, int i, int smallest) {
		sumList.add(smallest,sumList.get(smallest)+sumList.get(i));
		sumList.add(i,sumList.get(smallest)-sumList.get(i));
		sumList.add(smallest,sumList.get(smallest)-sumList.get(i));
	}

	public void maxHeapify(int val){

			int largest =val;
			if(2*val+1 < arr.length && arr[largest]<arr[val*2+1])
				largest=2*val+1;
			if(2*val+2 < arr.length && arr[largest]<arr[val*2+2])
				largest=2*val+2;
		if(largest!=val){

			arr=Utility.swapElements(arr,largest,val);

			maxHeapify((val-1)/2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     KthOrderStatisticsInArray obj = new KthOrderStatisticsInArray();
     obj.arr=new int[] {12, 3, 5, 7, 19};
     int k = 3;
     int kthSmallest=obj.findKthSmallest( k);
     System.out.println(k+"th smallest element ="+kthSmallest);


	obj.arr= new int[] {10, -10, 20, -40};
	k=6;
	int  kthLargestSumContiguousSubarray = obj.findKthLargestSumContiguousSubarray(6);
		System.out.println(k+"th largest sum contiguous sub-array ="+kthLargestSumContiguousSubarray);
	}

}
