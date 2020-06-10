package com.algorithims.sorting;

import com.utility.Utility;

/**
 * 
 * @author saurabh_mahambrey The Radix Sort Algorithm 1) Do following for each
 *         digit i where i varies from least significant digit to the most
 *         significant digit. ����.a) Sort input array using counting sort (or
 *         any stable sort) according to the i�th digit.
 * 
 *         Example: Original, unsorted list:
 * 
 *         170, 45, 75, 90, 802, 24, 2, 66 Sorting by least significant digit
 *         (1s place) gives: [*Notice that we keep 802 before 2, because 802
 *         occurred before 2 in the original list, and similarly for pairs 170 &
 *         90 and 45 & 75.]
 * 
 *         170, 90, 802, 2, 24, 45, 75, 66 Sorting by next digit (10s place)
 *         gives: [*Notice that 802 again comes before 2 as 802 comes before 2
 *         in the previous list.]
 * 
 *         802, 2, 24, 45, 66, 170, 75, 90 Sorting by most significant digit
 *         (100s place) gives:
 * 
 *         2, 24, 45, 66, 75, 90, 170, 802
 * 
 *         Complexity: we can sort an array of integers with range from 1 to nc
 *         if the numbers are represented in base n (or every digit takes
 *         log2(n) bits).
 */
public class RadixSort {
	int[] arr;

	public RadixSort(int[] arr) {
		super();
		this.arr = arr;
	}

	public void countingSortRoutine(int exp) {
		int[] positionArr = new int[10]; // position array based on significance
											// bits;
		int[] outputArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			positionArr[(arr[i] / exp) % 10]++;
		}

		int temp = 0;
		for (int i = 0; i < positionArr.length; i++) {
			if (positionArr[i] != 0) {
				positionArr[i] += temp;
				temp = positionArr[i];
			}
		}
		System.out.println("position");
		Utility.printArray(positionArr);

		// loop is in reverse compared to the couting sort algorithim because
		// we want to mantain the order in which the values were present before
		// performing count sort based on bits

		for (int i = arr.length - 1; i >= 0; i--) {

			outputArr[positionArr[(arr[i] / exp) % 10] - 1] = arr[i];
			positionArr[(arr[i] / exp) % 10]--;
		}
		System.out.println("output");
		Utility.printArray(outputArr);
		arr = outputArr;

	}

	public void radixsort() {
		// Find the maximum number to know number of digits
		int max = Utility.findLargest(arr);

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; max / exp > 0; exp *= 10)
			countingSortRoutine(exp);
		Utility.printArray(arr);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 22, 221, 5, 55, 40, 42, 33, 1, 2, 2323, 1,
				23, 44 };
		RadixSort obj = new RadixSort(arr);
		obj.radixsort();
		Utility.printArray(obj.arr);
	}

}
