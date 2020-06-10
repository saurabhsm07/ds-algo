package com.algorithims.divideAndConquer;

import com.utility.Utility;

/**
 * Created by saurabh_mahambrey on 1/17/2019.
 *
 * Problem Statement : Count number of inversions in a array
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

 solution : perform merge sort and sum all the points where element from the higher part is lesser than the element in the lower part
 */
public class CountInversions {
    private int arr[];
    static int countInversions=0;

    protected void divideArray(int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            divideArray(low, mid);
            divideArray(mid+1,high);
            countInversionsFnc(low,high,mid);
        }

    }

    protected  int countInversionsFnc(int low,int high,int mid){
        int arr1[]=new int[mid-low+1];
        int arr2[]=new int[high-mid];

        for(int i=0;i<arr1.length;i++)
            arr1[i]=arr[low+i];
        for(int i=0;i<arr2.length;i++)
            arr2[i]=arr[1+mid+i];
        int i=0,j=0,k=low;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;k++;
            }
            else{
                arr[k]=arr2[j];
                countInversions+=mid-i-1;
                j++;
                k++;
            }
        }
        while(i<arr1.length){
            arr[k]=arr1[i];

            i++;k++;
        }
        while(j<arr2.length){
            arr[k]=arr2[j];
            j++;k++;
        }
        return 0;
    }
    public static void main(String[] args) {
 CountInversions obj = new CountInversions();
        obj.arr = new int[] {2, 4, 1, 3, 5,-6,12,11,-1,-15,122};
        obj.divideArray(0,obj.arr.length-1);
        System.out.println("total inversions = " + countInversions);
        Utility.printArray(obj.arr);
    }


}
