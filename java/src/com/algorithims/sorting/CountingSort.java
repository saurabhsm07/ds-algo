package com.algorithims.sorting;

import com.utility.Utility;

/**
 * 
 * @author saurabh_mahambrey Counting Sort Counting sort is a sorting technique
 *         based on keys between a specific range. It works by counting the
 *         number of objects having distinct key values (kind of hashing). Then
 *         doing some arithmetic to calculate the position of each object in the
 *         output sequence.
 * 
 *         Let us understand it with the help of an example.
 * 
 *         For simplicity, consider the data in the range 0 to 9. Input data: 1,
 *         4, 1, 2, 7, 5, 2 1) Take a count array to store the count of each
 *         unique object. Index: 0 1 2 3 4 5 6 7 8 9 Count: 0 2 2 0 1 1 0 1 0 0
 * 
 *         2) Modify the count array such that each element at each index stores
 *         the sum of previous counts. Index: 0 1 2 3 4 5 6 7 8 9 Count: 0 2 4 4
 *         5 6 6 7 7 7
 * 
 *         The modified count array indicates the position of each object in the
 *         output sequence.
 * 
 *         3) Output each object from the input sequence followed by decreasing
 *         its count by 1. Process the input data: 1, 4, 1, 2, 7, 5, 2. Position
 *         of 1 is 2. Put data 1 at index 2 in output. Decrease count by 1 to
 *         place next data 1 at an index 1 smaller than this index.
 * 
 *         Time Complexity: O(n+k) where n is the number of elements in input
 *         array and k is the range of input. Auxiliary Space: O(n+k)
 */
public class CountingSort {
	int arr[];

	public CountingSort(int[] arr) {
		super();
		this.arr = arr;
	}

	public void countingSortImpl() {

		int[] positionArr = new int[Utility.findLargest(arr) + 1];
		int[] arrSorted = new int[arr.length];
		// for (int i = 0; i < positionArr.length; i++) {
		// positionArr[i]=0;
		// }
		for (int i = 0; i < arr.length; i++) {
			positionArr[arr[i]]++;
		}
		int prevCount = 0;
		/**
		 * method implementation : ssm Change count[i] so that count[i] now
		 * contains actual position of this character in output array dis
		 * advantage : looping through the position array twice once to store
		 * pos val second to sort poition store
		 */

		for (int i = 0; i < positionArr.length; i++) {
			if (positionArr[i] != 0) {
				positionArr[i] += prevCount;
				prevCount = positionArr[i];
			}
		}

		/**
		 * //sorting function for (int i = 0; i < positionArr.length; i++) {
		 * if((positionArr[i]!=0)){ int j=positionArr[i]-1; while(j>=0 &&
		 * arrSorted[j]==0 ) {
		 * 
		 * arrSorted[j]=i; j--;
		 * 
		 * } Utility.printArray(arrSorted); }
		 * 
		 * }
		 * 
		 * // geeks for geeks solution position storing algo - all the non
		 * elements are also updated for (int i = 1; i < positionArr.length;
		 * i++) { positionArr[i]+=positionArr[i-1]; }
		 */

		// geeks for geeks sorting function
		for (int i = 0; i < arrSorted.length; i++) {
			arrSorted[positionArr[arr[i]] - 1] = arr[i];
			--positionArr[arr[i]];

		}
		arr = arrSorted;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 22, 221, 5, 55, 40, 42, 33, 1, 2, 2323, 1,
				23, 44 };
		CountingSort obj = new CountingSort(arr);

		obj.countingSortImpl();
		Utility.printArray(obj.arr);

	}
}
