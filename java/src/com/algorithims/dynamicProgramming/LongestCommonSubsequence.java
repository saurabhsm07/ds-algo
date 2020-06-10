package com.algorithims.dynamicProgramming;

 /**
 * @author saurabh_mahambrey
 *Problem Statement:find the longest common subsequence between 2 strings
 */
public class LongestCommonSubsequence { 
int LcsTable[][];	 
	
public  int findSequence(String string1,String string2){
	char arr1[] = string1.toCharArray();
	char arr2[] =string2.toCharArray();
	LcsTable = new int[arr1.length+1][arr2.length+1];
	for(int i=0;i<=arr1.length;i++){
		for (int j = 0; j <=arr2.length; j++) {
			
		
			if(i==0 || j==0){
				LcsTable[i][j]=0;
			}
			else if(arr1[i-1]==arr2[j-1]){
				
				LcsTable[i][j]=LcsTable[i-1][j-1]+1;
				System.out.println(arr1[i-1]+" = "+arr2[j-1]+"  "+LcsTable[i][j]);
			}
			else {
				if(LcsTable[i][j-1]>LcsTable[i-1][j]){
					LcsTable[i][j]=LcsTable[i][j-1];
					
				}
				else{
					LcsTable[i][j]=LcsTable[i-1][j];
				}
				System.out.println(arr1[i-1]+"! = "+arr2[j-1]+"--->"+LcsTable[i][j]);
			}
		}

	}
	return LcsTable[arr1.length][arr2.length];
}

public static void main(String args[]){
	LongestCommonSubsequence lcsObj = new LongestCommonSubsequence();
	
	 String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	    System.out.println("Length of LCS is" + " " +
	    		lcsObj.findSequence(s1,s2) );
	
}
	 
 } 