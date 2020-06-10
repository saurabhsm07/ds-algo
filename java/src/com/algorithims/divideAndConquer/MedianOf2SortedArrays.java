package com.algorithims.divideAndConquer;
/**
 * 
 * @author saurabh_mahambrey
 *problem Statement :
 *There are 2 sorted arrays A and B of size n each. 
 *Write an algorithm to find the median of the array obtained after 
 *merging the  2 arrays
 *(i.e. array of length 2n). The complexity should be O(log(n)).
 *
 *Algorithim :
 * 1) Calculate the medians m1 and m2 of the input arrays ar1[]
and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
return m1 (or m2)
3) If m1 is greater than m2, then median is present in one
of the below two subarrays.
a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one
of the below two subarrays.
a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays
becomes 2.
6) If size of the two arrays is 2 then use below formula to get
the median.
Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
 */
public class MedianOf2SortedArrays {

	/**
	 * @param args
	 */
	
	public static int getMedian(int arr1[],int arr2[],int l1,int h1,int l2,int h2){
		
		int median1=0,median2=0, fl=0;
		
	for (int i = l1; i < h1; i++) {
		System.out.print("  "+arr1[i]);
	}
	System.out.println();
	for (int i = l2; i < h2; i++) {
		System.out.print("  "+arr2[i]);
	}
	System.out.println();
		System.out.println("l1 ="+l1+" l2 ="+l2+" h1 ="+h1+" h2 ="+h2);
		if(h1-l1>2){
		if(((l1%2)==0) && ((h1%2)==0)){
			fl=1;
			System.out.println("median method 1");
			median1=(arr1[(l1+h1)/2]+arr1[(l1+h1)/2-1])/2;
			median2=(arr2[(l2+h2)/2]+arr2[(l2+h2)/2-1])/2;
		}
		else {
			fl=0;
			System.out.println("median method 2");
			median1= arr1[(l1+h1)/2];
			median2=arr2[(l2+h2)/2];
		}
		System.out.println("medians m1= "+median1+" m2= "+median2);
		
		if(median1==median2)
		return median1;
		
		else if(median1>median2){
			return getMedian(arr1, arr2,l1,(l1+h1)/2+1,(l2+h2)/2-fl,h2);
		}
		else{
		return getMedian(arr1, arr2,(l1+h1)/2-fl,h1,l2,(l2+h2)/2+1);
		}
		}
		else{
			System.out.println("final calculation");
			return (Math.max(arr1[l1], arr2[l2])+Math.min(arr1[h1-1], arr2[h2-1]))/2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int ar1[] = {1, 12, 15, 26, 38};
//		int ar2[] = {2, 13, 17, 30, 45};
		int ar1[] ={10, 11, 13, 15, 16, 23, 26,28};
		int ar2[]={14, 21, 25, 28, 32, 35, 38,40};
//		int ar1[] = {1, 2, 3, 6};
//	    int ar2[] = {4, 6, 8, 10};
	System.out.println(getMedian(ar1, ar2, 0, ar1.length, 0, ar2.length));
	}

}
