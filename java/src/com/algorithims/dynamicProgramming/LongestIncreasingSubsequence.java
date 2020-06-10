package com.algorithims.dynamicProgramming;

import com.utility.Utility;

import java.util.Stack;

/**
 * 
 * @author saurabh_mahambrey Longest Increasing Subsequence: Optimal
 *         Substructure: Let arr[0..n-1] be the input array and L(i) be the
 *         length of the LIS ending at index i such that arr[i] is the last
 *         element of the LIS. Then, L(i) can be recursively written as: L(i) =
 *         1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or L(i) = 1, if
 *         no such j exists. To find the LIS for a given array, we need to
 *         return max(L(i)) where 0 < i < n. Thus, we see the LIS problem
 *         satisfies the optimal substructure property as the main problem can
 *         be solved using solutions to subproblems.
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static int findLongestIncreasingSubsequence(int[] ipArr) {
		int[] seqCount = new int[ipArr.length];
		for (int i = 0; i < seqCount.length; i++) {
			seqCount[i] = 1;
		}
		for (int i = 1; i < seqCount.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((ipArr[i] > ipArr[j]) && (seqCount[i] < seqCount[j] + 1)) {
					seqCount[i] = seqCount[j] + 1;
				}
			}
		}
		int max = printLongestIncreasingSubsequence(ipArr, seqCount);
		System.out.println();

		return max;

	}

	protected static int printLongestIncreasingSubsequence(int[] ipArr,
			int[] seqCount) {
		int max = Utility.findLargest(seqCount);
		Stack<Integer> dataStack = new Stack<Integer>();
		Utility.printArray(seqCount);
		int current = ipArr[ipArr.length - 1];
		for (int i = seqCount.length - 1; i >= 0; i--) {

			if (max == seqCount[i]) {

				current = ipArr[i];
				System.out.println(i);
			} else if (max == seqCount[i] + 1) {

				max--;
				dataStack.add(current);
				current = ipArr[i];

			}
		}
		if (current != dataStack.peek())
			dataStack.add(current);

		while (!dataStack.isEmpty()) {
			System.out.print(" " + dataStack.pop());
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(" longest increasin subsequence length= "
				+ findLongestIncreasingSubsequence(arr));

	}

}
