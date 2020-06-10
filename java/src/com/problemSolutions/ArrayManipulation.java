package com.problemSolutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

    /*
     * Complete the arrayManipulation function below.
     */
    static int arrayManipulation(int n, int[][] queries) {
        /*
         * Write your code here.
         */
    	int arr[] = new int[n];
    	
    	for (int i = 0; i < arr.length; i++) {
			arr[i]=0;
		}
    	for (int i = 0; i < queries.length; i++) {
    		if((i<=queries[i][1])&&(i>=queries[i][0])) {
    			arr[i]++;
    		}
    	}
for (int i = 0; i < queries.length; i++) {
	arr[queries[i][0]-1]=queries[i][2];
	arr[queries[i][1]-1]=-queries[i][2];
}
int max =0;
for (int i = 0; i < arr.length; i++) {
	if(max<arr[i])
		max=arr[i];
}
return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] queries = new int[m][3];

        for (int queriesRowItr = 0; queriesRowItr < m; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
