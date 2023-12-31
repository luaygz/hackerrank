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
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
        // initialize list with 100 zeroes
        List<Integer> countingArray = new ArrayList<>();
        for(int i=0;i<100;i++) {
            countingArray.add(0);
        }
        // sort list by counting number of occurrences of each value in list
        // counts are stored in a frequency array where the index is the value being counted
        // indices are inherently in numerical order, so list is getting sorted
        // and array lookup is O(1) (we are using ArrayList)
        // sorted array can then be generated by repeating each value `count` times
        for(int num: arr) {
            int count = countingArray.get(num);
            count++;
            countingArray.set(num, count);
        }
        // unroll countingArray by printing each value `count` times
        for(int num: countingArray) {
            for(int i=0;i<num;i++) {
                System.out.print(num);
            }
        }
        System.out.println();
        return countingArray;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
