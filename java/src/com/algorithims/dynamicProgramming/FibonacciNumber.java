package com.algorithims.dynamicProgramming;

public class FibonacciNumber {

	/**
	 * @param args
	 */
	static long storedFibo[];
	
	/**
	 * 
	 * @param number
	 * @return fibonacci val
	 * 
	 * function iteratively finds the sum of previous 2 numbers until we reach the input number n ;
	 * works similar to tabulation method of dynmaic programming since we calculating sum of numbers
	 * solution : linear time
	 */
	public static long getFibonacciIterative(int number){
		if(number<=1){
			return number;
		}
		else{
			long sum=0;
			long f1=0,f2=1;
			for (int i = 2; i <=number; i++) {
				sum=f1+f2;
			 f1=f2;
			 f2=sum;
			}
			return sum;
		}
	}
	
	/**
	 * 
	 * @param number
	 * @return fibonacci val
	 * 
	 * function recursively finds the fibonacci number by recursively calling the function to calculate fibo of (n-1) . (n-2)
	 * until we hit the base case of n=0,1 .. 
	 * solution: n^2;
	 */
	public static long getFibonacciRecursive(int number){
		if(number<=1){
			return number;
		}
		else {
			return getFibonacciRecursive(number-1)+getFibonacciRecursive(number-2);
		}
	}
	
	/**
	 * 
	 * @param number
	 * @return fibonacci val
	 * 
	 * function iteratively finds the fib of numbers from num :1 to number and stores intermiediate values in table to avoid recomputation
	 * finally return solution. bottom-up method
	 * solution: n;
	 */
	public static long getFibonaccDpTabulation(int number){
		if(number<=1){
			return number;
	}
	else{
		long[] arr = new long[number+1];
		arr[0]=0;arr[1]=1;
		for (int i = 2; i <=number; i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[number];
	}
}
	/**
	 * 
	 * @param number
	 * @return fibonacci val
	 * 
	 * function recursive finds the fib of numbers from num :number to 1 and stores the values in table to avoid recomputation
	 * finally return solution.
	 * works as the problem optimal substructure property. 
	 *  top-down method
	 * solution: faster than tabulation ! ,less wastage of calculation;
	 */
	private static long getFibonaccDpMemoization(int number) {
		// TODO Auto-generated method stub
		
		
		
		if(number<=1){
		return number;
		}
		else{
		if(storedFibo[number]==-1){
			storedFibo[number]=getFibonaccDpMemoization(number-1)+getFibonaccDpMemoization(number-2);
		}
		return storedFibo[number];
		}
		
		
	}
	

	protected static void memoizationInitializer(int number) {
		storedFibo = new long[number+1];  //initializing number for memoisation
		for (int i = 0; i < storedFibo.length; i++) {
			storedFibo[i]=-1;	
			}
			storedFibo[0]=0;storedFibo[1]=1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int number=50;
		
		
 System.out.println("fibonacci iterative : "+getFibonacciIterative(number));
 System.out.println("fibonacci Recursive: "+getFibonacciRecursive(number));
 System.out.println("fibonacci Dp-Tabulation: "+getFibonaccDpTabulation(number));
 
 memoizationInitializer(number);
 System.out.println("fibonacci Dp-Memoization: "+getFibonaccDpMemoization(number));
	}





	

}
