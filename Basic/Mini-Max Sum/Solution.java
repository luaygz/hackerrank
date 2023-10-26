import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        // outer loop iterates through the 5 permutations of the list having one number omitted
        // skipping the i'th number each time
        // inner loop does the summing
        for(int i=0;i<arr.size();i++) {
            long total = 0;
            for(int j=0;j<arr.size();j++) {
                if(j != i) total += arr.get(j);
            }
            if(total < min) min = total;
            if(total > max) max = total;
        }
        System.out.println(String.format("%d %d", min, max));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
