package com.structArrays;

import com.utility.Utility;

import java.util.Arrays;

public class ArraysTrivialProblems {
   private int arr[];

    /**
     * Problem statement :Given an array of random numbers, Push all the zero’s of a given
     * array to the end of the array
     */
   protected void moveAllZeros(){

       for (int i=0,count=0;i<arr.length;i++){
        if(arr[i]==0){
            count++;
        }
        if(arr[i]!=0 && count>0){
            arr[i-count]=arr[i];
            arr[i]=0;
        }
    }
   }

    /**
     * Problem Statement :Given an array arr[] of n integers, find the maximum that maximizes sum of value of
     * i*arr[i] where i varies from 0 to n-1.
    */
    protected int  maxRotationSum(){
        int maxSum=0,nextSum=0,currentSum=0,eleSum=0;
        for (int i=0;i<arr.length;i++){
            currentSum+=arr[i]*i;
            eleSum+=arr[i];
        }
        maxSum=currentSum;
        for (int i=1;i<arr.length;i++){

            nextSum=currentSum-eleSum+arr[i-1]*arr.length;
            maxSum=Math.max(maxSum,nextSum);
            currentSum=nextSum;
        }

     return maxSum;
    }

    /**
     *Problem Statement: Given an array A of n elements, sort the array according to the following relations :
     A[i] >= A[i-1]  , if i is even.
     A[i] <= A[i-1]  , if i is odd.
     Print the resultant array.
     */
    protected void rearrangeArray1(){
        for (int i=1;i<arr.length;i++){
            if((i+1)%2==0 && (arr[i]<=arr[i-1])){
                Utility.swapElements(arr,i,i-1);
            }
        }
     Utility.printArray(arr);
    }

    /**
     * Problem Statement : Given an array of size n where all elements are distinct and in range from 0 to n-1,
     * change contents of arr[] so that arr[i] = j is changed to arr[j] = i.
     * the below program works without the complex while loop conditions only if the array does not contain internal cycles
     *
     * link : https://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
     */
    protected void rearrangeArray2(){
       int pos=arr[0],val=0,count=0;
        while((val<arr.length && pos<arr.length)||(pos >=arr.length && val<arr.length-1)){
            if(pos==val){
                System.out.print("pos = "+pos);
                arr[pos]=val+arr.length;
                pos++;
                val=pos;
                if(pos<arr.length-1)
                pos=arr[pos];
            }
             else if(pos>=arr.length){
                pos=val;
                 pos++;
                 val=pos;
                 pos=arr[pos];
             }
            else{
                int temp = arr[pos];
                arr[pos]=val+arr.length;
                val=pos;
                pos=temp;
            }
        }
        System.out.print("val="+pos);
        printSubArray(arr, arr.length);
    }

    /**
     * Problem Statement : An Array of integers is given, both +ve and -ve.
     *  You need to find the two elements such that their sum is closest to zero
     *
     * solution :
     * step 1:sort array 0(nlogn)
     * ste 2: traverse both ends to find best combo
     */
    protected void twoEleSum(){
     int sum,leftEle=1,rightEle=arr.length-2,ele1=0,ele2=arr.length-1;
        Arrays.sort(arr);
        Utility.printArray(arr);
        sum=Math.abs(arr[0]+arr[arr.length-1]);
        while(arr[leftEle]<arr[rightEle]){
            int tempSum=Math.abs(arr[leftEle]+arr[rightEle]);
            if(sum>tempSum){
                sum=tempSum;
                ele1=leftEle;
                ele2=rightEle;
            }
            if(tempSum>0){
                rightEle--;
            }
            else{
                leftEle++;
            }
        }

     System.out.println("ele 1 = " + arr[ele1] + " \n ele 2 = " + arr[ele2]);
    }

    /**DYNAMIC PROGRAMMING
     * Problem Statement: Given an array of positive numbers, find the maximum sum of a subsequence with the constraint
     * that no 2 numbers in the sequence should be adjacent in the array
     *
     * example : 3 2 5 10 7 should return 15 (sum of 3, 5 and 7)
     *
     * Algorithim :
     * we traverse the array and at each elemet we decide weather to select this element in our total sum or not.
     * if we select the current element then we exclude its previous adjacent element
     * else we keep the sum till previous element and exclude this element
     *
     * we keep on updating the 2 sums (include,exclude) as the sum of either selecting or not selecting the current element.
     *
     * at the end we return the maximum of include or exclude which by the end contains the maximum sum of till the selected final element
     * or excluded final element.
     *
     * link : https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
     * 
     * @return sum  : max sum of non adjacent elements
     */
    protected int nonAdjacentMaxSum(){
        int includeCurrent,excludeCurrent,includeCurrentNew=0,excludeCurrentNew=0;

        includeCurrent=arr[0];
        excludeCurrent=0;

        for(int i=1;i<arr.length;i++){
            includeCurrentNew=arr[i]+excludeCurrent;
            excludeCurrentNew=Math.max(includeCurrent,excludeCurrent);
            includeCurrent=includeCurrentNew;
            excludeCurrent=excludeCurrentNew;
        }
      int sum=Math.max(includeCurrentNew,excludeCurrentNew);

        return  sum;
    }
    public static void printSubArray(int arr[],int val){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>val)
            System.out.print(arr[i]-val+" , ");
            else
                System.out.print(arr[i]+" , ");
        }

    }

   public static void main(String args[]){
       ArraysTrivialProblems obj = new ArraysTrivialProblems();
       obj.arr=new int[]{1,2,0,0,5,0,12,8,8,0,14,1,0,0,0,4};
       obj.moveAllZeros();
       Utility.printArray(obj.arr);

       obj.arr=new int[]{8, 3, 1, 2};
       int maxSum=obj.maxRotationSum();
       System.out.print("maximum sum of products of arr[i]*i from rotations is = "+maxSum);

       obj.arr = new int[]{1, 3, 2, 2, 5};
       obj.rearrangeArray1();


       obj.arr = new int[]{2, 0, 1, 4, 5, 3, 7, 8, 6,11,9,10,14,13,12};
       obj.rearrangeArray2();

        obj.arr = new int[]{1, 60, -10, 70, -80, 85};
        obj.twoEleSum();

       obj.arr = new int[]{5,5,10,100,10,5};
       int sum=obj.nonAdjacentMaxSum();
       System.out.println("Maximum sum of non adjacent elements of the given array = " + sum);
   }
}
