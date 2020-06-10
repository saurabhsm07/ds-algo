package com.algorithims.sorting;

import com.utility.Utility;

/**
 * 
 * @author saurabh_mahambrey HEAP SORT: Since a Binary Heap is a Complete Binary
 *         Tree, it can be easily represented as array and array based
 *         representation is space efficient. If the parent node is stored at
 *         index I, the left child can be calculated by 2 * I + 1 and right
 *         child by 2 * I + 2 (assuming the indexing starts at 0).
 * 
 *         Heap Sort Algorithm for sorting in increasing order: 1. Build a max
 *         heap from the input data. 2. At this point, the largest item is
 *         stored at the root of the heap. Replace it with the last item of the
 *         heap followed by reducing the size of heap by 1. Finally, heapify the
 *         root of tree. 3. Repeat above steps while size of heap is greater
 *         than 1.
 * 
 *         time complexity of Heap Sort is O(nLogn)
 */
public class HeapSort {

	public void sort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			Utility.swapElements(arr, 0, i);

			heapify(arr, i, 0);
		}

	}

	private void heapify(int[] arr, int n, int i) {
		// TODO Auto-generated method stub
		int largest = i;
		int left = i * 2 + 1;
		int right = i * 2 + 2;

		if (left < n && arr[largest] < arr[left]) {
			largest = left;
		}
		if (right < n && arr[largest] < arr[right]) {
			largest = right;
		}
		if (largest != i) {
			Utility.swapElements(arr, largest, i);
			heapify(arr, n, largest);
		}

	}

	public static void main(String[] args) {
		HeapSort obj = new HeapSort();
		int[] arr = { 1, 22, 221, 5, 55, 40, 42, 33, 1, 2, 2323, 1, 23, 44 };
		obj.sort(arr);
		Utility.printArray(arr);
	}
}
