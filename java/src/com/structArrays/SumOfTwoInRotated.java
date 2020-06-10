package com.structArrays;

/**Problem statement : Given a sorted and rotated array, find if there is a pair with a given sum
 *
 * Example :
 * Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
 * Output: true
 * There is a pair (6, 10) with sum 16
 */
public class SumOfTwoInRotated {

    /**
     *
     * @param arr - array to be parsed
     * @param sum - sum to be found
     * @return if the sum is attained using 2 numbers  from array or not
     */
    public boolean checkSumOf2(int arr[],int sum){
        int pivot = findPivot(arr,0,arr.length);
        int smallest=pivot+1;
        int largest=pivot;
        System.out.println(arr[smallest]+"  "+arr[largest]);
        while(largest!=smallest){
            if (arr[largest]+arr[smallest]==sum)
                return true;
                if(arr[largest]+arr[smallest]>sum)
                    largest=(largest+arr.length-1)%arr.length;
                else
                    smallest=(smallest+1)%arr.length;

        }
    return false;
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     * @return    the point till which this sorted array is rotated
     */
    public int findPivot(int arr[],int low,int high){
        int mid = (low+high)/2;
        System.out.println("current mid="+mid);
        if(high<low)
            return -1;
        if(low<mid && arr[mid]<arr[mid-1])
            return  mid-1;
        if(mid<high && arr[mid]>arr[mid+1])
            return mid;
        if(arr[mid]<arr[low]){
            return findPivot(arr,low,mid-1);
        }
        else
            return findPivot(arr,mid+1,high);
    }

    public static void main(String args[]){
SumOfTwoInRotated obj = new SumOfTwoInRotated();
int arr1[] = new int[]{11, 15, 26, 38, 9, 10}, sum1 = 45;
int arr2[]=new int [] {11, 15, 26, 38, 9, 10},sum2=35;
boolean result=obj.checkSumOf2(arr1,sum1);
    System.out.println(result);
    }
}
