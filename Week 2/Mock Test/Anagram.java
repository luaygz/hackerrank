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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
        if(s.length() % 2 == 1) return -1;
        String left = s.substring(0, s.length()/2);
        String right = s.substring(s.length()/2, s.length());
        HashMap<Character, Integer> leftLetterCounts = new HashMap<>();
        HashMap<Character, Integer> rightLetterCounts = new HashMap<>();
        for(int i=0;i<left.length();i++) {
            char c = left.charAt(i);
            int count = leftLetterCounts.getOrDefault(c, 0);
            count++;
            leftLetterCounts.put(c, count);
            
            c = right.charAt(i);
            count = rightLetterCounts.getOrDefault(c, 0);
            count++;
            rightLetterCounts.put(c, count);
        }
        
        int numLettersInCommon = 0;
        for(char letter: "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            int leftCount = leftLetterCounts.getOrDefault(letter, 0);
            int rightCount = rightLetterCounts.getOrDefault(letter, 0);
            if(leftCount <= rightCount) numLettersInCommon += leftCount;
            else numLettersInCommon += rightCount;
        }
        return left.length() - numLettersInCommon;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
