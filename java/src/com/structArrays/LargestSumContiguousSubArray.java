package com.structArrays;

/**Largest Sum Contiguous Subarray (dynamic programming)
 * Problem Statement :
 Write an efficient program to find the sum of contiguous subarray within a
 one-dimensional array of numbers which has the largest sum.
 */
public class LargestSumContiguousSubArray {
    /**solution :
     * Simple idea of the Kadane’s algorithm is to
     * look for all positive contiguous segments of the array (max_ending_here is used for this seriesmax).
     * And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this currentMax
     *
     * link : https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/)
     *
     * @param arr
     * @return the contigious subarray sum.
     */
    public int getMaxContiguousSum(int arr[]){
        int currentMax=0,seriesMax=0,start=0,end=0;
        for (int i=0;i<arr.length;i++){
            seriesMax+=arr[i];
            if(seriesMax<0){
                seriesMax=0;
                start=i+1;
            }
            if(currentMax<seriesMax){
                end=i;
            currentMax=seriesMax;}
        }
        System.out.println("sub array starts at ="+start+"  ends at="+end);
        return currentMax;
    }


    public static void main(String args[]){
        LargestSumContiguousSubArray obj = new LargestSumContiguousSubArray();
        int arr[] = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum=obj.getMaxContiguousSum(arr);
        
        System.out.println("Sum = "+sum);
    }
}


