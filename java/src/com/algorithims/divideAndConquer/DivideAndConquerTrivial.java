package com.algorithims.divideAndConquer;

/**
 * Created by saurabh_mahambrey on 1/18/2019.
 */
public class DivideAndConquerTrivial {
    /**
     *
     * solution : use binary search and findtrailing zeros function
     */
    protected void findTrailingZeros(int number, int min, int max){
        int mid=(min+max)/2;

        if(min<max) {
            if (getTrailingZeros(mid) == number) {
                System.out.println("list is as follows :");
                System.out.print(mid +" ");
                int midMin=mid-1,midMax=mid+1;
                while(getTrailingZeros(midMin)==number){
                System.out.print(" " + midMin);
                   midMin--;
                }
                while(getTrailingZeros(midMax)==number){
                    System.out.print(" "+midMax);
                    midMax++;
                }


            }
            else if (getTrailingZeros(mid) > number) {
//                System.out.println("greater "+mid);
                findTrailingZeros(number, min, mid - 1);
            } else {
//                System.out.println("smaller"+mid);
//                System.out.println("max="+max);
                findTrailingZeros(number, mid + 1, max);
            }
        }
    }


    /**
     *
     * @param number
     * @return
     * Problem Statement : Count Trailing Zeros in a numbers factorial
     * Answer : it is equal to the number of 5's present in the factorial
     *
     * algoritim : Trailing 0s in n! = Count of 5s in prime factors of n!
    = floor(n/5) + floor(n/25) + floor(n/125) + ....
     */
    public static int getTrailingZeros(int number){
        int count=0,num5=5;

        while(number/num5 > 0){
            count += Math.floor(number/num5);
            num5*=5;
        }

        return count;
    }

    /**
     solution :
     1) Divide the given array in two halves
     2) Return the maximum of following three
     ….a) Maximum subarray sum in left half (Make a recursive call)
     ….b) Maximum subarray sum in right half (Make a recursive call)
     ….c) Maximum subarray sum such that the subarray crosses the midpoint (findMiddleSum)

     The above solution takes time similar to divide and conquer but is too slow compared to kadens method (dynamic programming) see :
     com.structArrays.LargestSumContiguousSubArray
     */
    protected  int findMaxSubArraySum(int arr[], int min, int max){
        if(min==max)
            return arr[min];
        else {
            int mid=(min+max)/2;
            return Math.max(findMiddleSum(arr,min,max,mid),Math.max(findMaxSubArraySum(arr, min, mid), findMaxSubArraySum(arr, mid + 1, max)));
        }

    }

    private int findMiddleSum(int[] arr, int min, int max, int mid) {
        int leftSum= Integer.MIN_VALUE;
        int rightSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=min;i--){
            sum+=arr[i];
            if(sum>leftSum)
                leftSum=sum;
        }
        sum=0;
        for(int i=mid+1;i<=max;i++){
            sum+=arr[i];
            if(sum>rightSum)
                rightSum=sum;
        }
    return leftSum+rightSum;
    }



    protected String longestSequenceInWordArray(String arr[],int min,int max){
        if(min==max)
            return arr[min];
        else {
            int mid=(min+max)/2;
            return matchStringsPrefix(longestSequenceInWordArray(arr, min, mid), longestSequenceInWordArray(arr, mid + 1, max));
        }
    }

    private String matchStringsPrefix(String s1, String s2) {
        String sequence="";
        for(int i=0,j=0;i<s1.length() && j<s2.length();i++,j++){
            if(s1.charAt(i)==s2.charAt(j))
                sequence+=s1.charAt(i);
            else
                break;
        }
    return sequence;
    }

    /**
     * solution : we could go linearly and find it in o(n) time or binary search the arr[mid] compare it with arr[0]+diff*mid if it matches :
     * do bsearch in left half and right half. if it does not than return the value.
     * @param arr
     * @param min
     * @param max
     * @return
     */
    protected int missingEleInAP(int arr[],int min,int max,int diff){
        if(min>max)
            return 0;

        else{
            int mid=(min+max)/2;
            if(arr[mid]==arr[0]+mid*(diff)) {
                System.out.println("true");
                return missingEleInAP(arr, mid + 1, max, diff);
            }
            else {
                System.out.println("false");
                if(arr[mid]-arr[mid-1]==diff)
                return  missingEleInAP(arr,min,mid,diff);
                else
                    return (mid+1)*diff;
                }

            }

        }


    public static void main(String[] args) {
        DivideAndConquerTrivial obj = new DivideAndConquerTrivial();

        testProblem1(obj, 3, 0, Integer.MAX_VALUE);

        testProblem2(obj, new int[]{-2, -5, 6, -2, 1, -3, 5, -6});

        testProblem3(obj, new String[]{"geeksforgeeks", "geeks", "geek", "geekzer"});

        testProblem4(obj, new int[]{2, 4, 6, 8, 10, 12, 16, 18});
    }

    /**
     * Problem Statement : Given an array that represents elements of arithmetic progression in order.
     * One element is missing in the progression, find the missing number
     *
     * @param obj
     * @param ints
     */
    private static void testProblem4(DivideAndConquerTrivial obj, int[] ints) {

         /*test array to check for breakage for large conditions :*/

//        int arr[] = new int[300000000];
//        arr[0]=2;
//        int diff=2;
////        System.out.println("int max="+Integer.MAX_VALUE);
//        System.out.println("actual missing element ="+(2+2*(280000000-1)));
//        int c=0;
//        for(int i=1;i<300000000;i++){
//            if(i!= 280000000)
//            arr[i]=arr[0]+(i+c)*diff;
//
//            else{
//                arr[i]=arr[0]+(i+1)*diff;
//                c=1;
//            }
//        }

        int diff=Math.abs((ints[0] - ints[ints.length - 1])/ints.length);
        int missingEle=obj.missingEleInAP(ints,0,ints.length-1,diff);
        System.out.println("missing element = "+missingEle);

//        going through the list linearly
        for(int i=1;i<ints.length;i++){
            System.out.println("itr number = "+i);
            if(ints[i]!= i*diff+ints[0]){
                System.out.println("itr number = "+i);
                System.out.println("missing value ="+(i)*diff);
                break;}
        }
    }


    /**Problem Statement : Given a set of strings, find the longest common prefix.
     Examples:

     Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
     Output : "gee"

     Input  : {"apple", "ape", "april"}
     Output : "ap"
     *
     * @param obj
     * @param arr
     */
    private static void testProblem3(DivideAndConquerTrivial obj, String[] arr) {
        String sequence= obj.longestSequenceInWordArray(arr, 0, arr.length-1);
        System.out.println("longest sequence in the given array = "+sequence);
    }

    /**
     * Problem statement 2 : You are given a one dimensional array that may contain both positive and negative integers,
     * find the sum of contiguous subarray of numbers which has the largest sum.
     *
     * example :  if the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray sum is 7
     *
     * link :https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
     *
     * @param obj
     * @param arr
     */
    private static void testProblem2(DivideAndConquerTrivial obj,int arr[]) {
       int sum= obj.findMaxSubArraySum(arr,0,arr.length-1);
        System.out.println("max contigious sum ="+sum);
    }

    /**
     *  Problem Statement 1: Given an integer n, we need to find the number of positive integers whose factorial ends with n zeros.
     * @param obj
     * @param number
     * @param min
     * @param max
     */
    private static void testProblem1(DivideAndConquerTrivial obj,int number,int min,int max) {

        obj.findTrailingZeros(number, min, max);
    }

}
