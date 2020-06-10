package com.tests;

import com.algorithims.sorting.HeapSort;
import com.algorithims.sorting.MergeSort;
import com.algorithims.sorting.QuickSort;
import com.utility.Utility;

public class TestSortingAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// function to test merge sort----------------1
//		testMerge();

		// function to test heap sort-----------------2
//		testHeap();

		// function to test quick sort-----------------3
		testQuick();

	}
	
	
	

	public static void testHeap() {
		int[] array = { 10, 5, 12, 20, 60, 33,44 };

		HeapSort hp = new HeapSort();
		hp.sort(array);

		Utility.printArray(array);

	}

	public static void testMerge() {
		int[] array = { 10, 5, 12, 20, 60 };

		MergeSort md = new MergeSort();
		md.sort(array, 0, array.length - 1);
		
		Utility.printArray(array);

	}
	
	public static void testQuick() {
		int[] array = { 10, 5, 12, 20, 60, 33,44 };

		QuickSort qc = new QuickSort();
		qc.sort(array,0,array.length-1);

		Utility.printArray(array);

	}

}
