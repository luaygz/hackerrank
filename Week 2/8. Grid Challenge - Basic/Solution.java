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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    
    public static boolean checkSorted(char[][] grid) {
        // rows
        for(int row=0;row<grid.length;row++) {
            for(int col=0;col<grid[row].length-1;col++) {
                if(grid[row][col] > grid[row][col+1]) return false;
            }
        }
        
        // columns
        for(int row=0;row<grid.length-1;row++) {
            for(int col=0;col<grid[row].length;col++) {
                if(grid[row][col] > grid[row+1][col]) return false;
            }
        }
        return true;
    }
    
    public static String gridChallenge(List<String> grid) {
    // Write your code here
        char[][] charGrid = new char[grid.size()][grid.get(0).length()];
        
        for(int i=0;i<grid.size();i++) {
            char [] line = grid.get(i).toCharArray();
            Arrays.sort(line);
            charGrid[i] = line;
        }
        
        return checkSorted(charGrid) ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

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
