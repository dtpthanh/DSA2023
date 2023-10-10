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

public class EqualStacks {
  class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
      // Write your code here
      int sum1 = 0, sum2 = 0, sum3 = 0;
      for (int x: h1) sum1 += x;
      for (int x: h2) sum2 += x;
      for (int x: h3) sum3 += x;

      int i = 0, j = 0, k = 0;
      while (sum1 != sum2 || sum2 != sum3) {
        if (sum1 > sum2 || sum1 > sum3) {
          sum1 -= h1.get(i);
          i++;
        }
        else if (sum2 > sum1 || sum2 > sum3) {
          sum2 -= h2.get(j);
          j++;
        }
        else if (sum3 > sum2 || sum3 > sum1) {
          sum3 -= h3.get(k);
          k++;
        }
      }
      return sum1;
    }

  }
  public static void main(String[] args) throws IOException {
  }
}
