package com.structArrays;
import com.utility.*;
/**
 * @author saurabh_mahambrey
divide the array in different sets
where number of sets is equal to GCD of n and d and move the elements within sets.
If GCD is 1  (n = 7 and d =2), then elements will be moved within one set only, we just start with temp = arr[0]
 and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
 */
public class RotateElementsByD {

	/**
	 * @param args
	 */
	/**
	 * @param arr : input array to be rotated
	 * @param d : number of position to be rotated by
	 */
	public void rotateArray(int arr[],int d){
    int gcd=Utility.getGCD(arr.length,d);
    System.out.println(gcd);
    for (int count = 0; count < d; count++) {
    	int temp=0,pos=0;
    	if(gcd==1){
    		temp = arr[0];
    		pos =gcd;
    	}
    		else {
    	   temp = arr[count];	
    	 pos =count+gcd;
    	}
		while(pos<arr.length){
			arr[pos-gcd]=arr[pos];
			pos+=gcd;
		}
		arr[pos-gcd]=temp;
		System.out.println("after itr = "+(count+1));
		Utility.printArray(arr);
	}
    Utility.printArray(arr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   RotateElementsByD obj = new RotateElementsByD();
   obj.rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3);
//   obj.rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 2);
	}

}
