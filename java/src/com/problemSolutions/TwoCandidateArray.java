package com.problemSolutions;

import com.algorithims.sorting.HeapSort;
import com.utility.Utility;

public class TwoCandidateArray {

	/**
	 * @param args
	 */
public static void hasCandidates_MOne(int arr[],int sum){
	
	//using heap sort coded in services package
	HeapSort hp = new HeapSort();
	hp.sort(arr);
	int low = 0;
	int high =arr.length-1;
	while (low<high) {
		if(arr[low]+arr[high]==sum){
			System.out.println("candidates="+arr[low]+" "+arr[high]);
		break;
		}
		else if(arr[low]+arr[high]>sum){
			high--;
		
		}
		else{
			low++;
			
		}
	}
if(low==high){
	System.out.println("no candidates");
}
}
	
public static void hasCandidates_MTwo(int arr[],int sum){
	//no sorting required
	
	
	int small = Utility.findSmallest(arr);
	if(small<0){
		small = Math.abs(small);
	    sum+=(2*small);
		for (int i = 0; i < arr.length; i++) {
			arr[i]=arr[i]+small;
		}
		
	}
	
	boolean[] elementState =new boolean[Utility.findLargest(arr)+1]; 
	for (int i = 0; i < arr.length; i++) {
		int temp= sum-arr[i];
		if(temp>=0 && elementState[temp]){
			System.out.println("candidates="+(temp-small)+" "+(arr[i]-small));
		}
	elementState[arr[i]]=true;
	
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int Arr[] = {1, 4, 45, 6, 10, -8};
	        int sum = 16;
	      //hasCandidates_MOne(Arr, sum);
	        hasCandidates_MTwo(Arr, sum);
	}

}
