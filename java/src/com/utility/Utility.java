package com.utility;

public class Utility {

public static void printArray(int arr[]){
	
	for (int i = 0; i < arr.length; i++) {
		
		System.out.print(arr[i]+", ");
	}
	System.out.println();
}

public static int[] swapElements(int arr[],int i,int j){
	int temp = arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
		return arr;
	
	}

public static int findSmallest(int arr[]){
	int smallest = arr[0];
	for (int i = 1; i < arr.length; i++) {
		if(smallest > arr[i]){
			smallest=arr[i];
		}
	}
return smallest;
}

public static int findLargest(int arr[]){
	int largest = arr[0];
	for (int i = 1; i < arr.length; i++) {
		if(largest < arr[i]){
			largest=arr[i];
		}
	}
return largest;
}

/** summary :
 * Our solution is to use Euclidean algorithm . 
 * The idea is, GCD of two numbers doesn�t change 
 * if smaller number is subtracted from a bigger number.
 * @param a = num1
 * @param b = num2
 * @return
 */
public static int getGCD(int a,int b){
	
	if(a==0 || b==0){
		return 0;
	}
	if(a==b){
		return a;
	}
	if(a>b){
		return getGCD(a-b, b);
		}
	return getGCD(a, b-a);

}
}
