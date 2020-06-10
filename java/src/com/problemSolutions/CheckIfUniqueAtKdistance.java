package com.problemSolutions;

import java.util.HashSet;
import java.util.Set;

public class CheckIfUniqueAtKdistance {
private int arr[];

public static boolean getResults(int arr[],int k){
	Set<Integer> set = new HashSet<Integer>();
	for (int i = 0; i < arr.length; i++) {
	if(set.contains(arr[i])){
		return true;
	}
	set.add(arr[i]);
	if(i>=k){
		set.remove(arr[i-k]);
	}
	}
	return false;
}
	
	
	public static void main(String[] args) {
	    int arr[] = {10, 5, 3, 4,11,22,33, 3, 5, 6};
        if (getResults(arr, 3))
           System.out.println("Yes");
        else
           System.out.println("No");
    }
	}

