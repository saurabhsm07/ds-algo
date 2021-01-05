import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER_ARRAY space
     */

    public static int segment(int x, List<Integer> space) {
        // Write your code here
        int segmentMin[] = new int[x];
        for(int i=0; i< segmentMin.length; i++){
            segmentMin[i] = 0;
        }

        for(int i=0; i< x; i++){
            for(int j = i; j < x; j++){
                if(segmentMin[i] == 0){
                    segmentMin[i] = space.get(i + j);
                }else{
                    if(space.get(i + j) < segmentMin[i]){
                        segmentMin[i] = space.get(i + j);
                    }
                }
            }
        }

        for (int j = 0; j < segmentMin.length; j++) {
            System.out.println(segmentMin[j]);
        }


        return 0;
    }

}

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int spaceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> space = new ArrayList<>();

        for (int i = 0; i < spaceCount; i++) {
            int spaceItem = Integer.parseInt(bufferedReader.readLine().trim());
            space.add(spaceItem);
        }

        int result = Result.segment(x, space);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
