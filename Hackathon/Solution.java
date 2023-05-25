import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim()); // length of the main array

        int[] arr = new int[n];

        String a = bufferedReader.readLine();
        bufferedReader.close();
        String[] vals = a.split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(vals[i]);
            // System.out.println(arr[i]);
        }

        int negCounter = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                int sum = 0;
                // For loop to print subarray elements
                for (int k = i; k <= j; k++) {
                    sum += arr[k];

                    // System.out.print(arr[k] + " ");
                    // System.out.println("");
                }
                if (sum < 0) {
                    negCounter++;
                }


            }
        }
        System.out.println(negCounter);

        // For loop for end index

    }

}

