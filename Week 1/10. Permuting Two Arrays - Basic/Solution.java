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
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
    // Write your code here
        // optimally we want to maximize the smallest a+b pair, and check if it's greater than `k`
        // since if the smallest a+b >= k, then all do
        // to do this we add the smallest value from list A to the largest value from list B
        // and the second smallest from A to the second largest from B, etc.
        // this works because, if for example, we add the largest value from B to any value other than
        // the smallest from A, then at some point a smaller value from B will be added to the smallest
        // value from A, which will sum to something less than the optimal value
        // and we only care about maximizing the smallest a+b
        // so any permutation that leads to a smaller minimum a+b will be suboptimal
        // e.g. sort the lists first
        // A = [2 3,4,8,1000]
        // B = [52,5,3,2,1]
        // if we don't add 52+2, then we're forced to add another number from B to 2
        // and since all numbers after 52 are also smaller, we're forced to add a smaller number 
        // to a smaller number, which is suboptimal
        // this proves that it's optimal to add the largest from B to the smallest from A (or vice versa)
        // we can then pop those two off the lists
        // and by induction the same logic applies to the rest of the list
        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);
        for(int i=0;i<A.size();i++) {
            if(A.get(i) + B.get(i) < k) return "NO";
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.twoArrays(k, A, B);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
