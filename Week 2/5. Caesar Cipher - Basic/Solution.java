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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        char[] alphabetLower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] alphabetUpper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        HashMap<Character, Integer> alphabetLowerIndexLookup = new HashMap<>();
        HashMap<Character, Integer> alphabetUpperIndexLookup = new HashMap<>();
        String cipher = "";
        for(int i=0;i<26;i++) {
            alphabetLowerIndexLookup.put(alphabetLower[i], i);
        }
        for(int i=0;i<26;i++) {
            alphabetUpperIndexLookup.put(alphabetUpper[i], i);
        }
        for(char c: s.toCharArray()) {
            if(alphabetLowerIndexLookup.containsKey(c)) {
                int index = alphabetLowerIndexLookup.get(c);
                index = (index + k) % 26;
                cipher += alphabetLower[index];
            }
            else if(alphabetUpperIndexLookup.containsKey(c)) {
                int index = alphabetUpperIndexLookup.get(c);
                index = (index + k) % 26;
                cipher += alphabetUpper[index];
            }
            else {
                cipher += c;
            }
        }
        return cipher;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
