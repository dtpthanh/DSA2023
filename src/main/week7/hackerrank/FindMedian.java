import edu.princeton.cs.algs4.In;
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



public class FindMedian {
  class Result {

  /*
   * Complete the 'findMedian' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

    public static int findMedian(List<Integer> arr) {
      // Write your code here
      Collections.sort(arr);
      int n = arr.size();
      return arr.get((n-1)/2);
    }

}
  public static void main(String[] args) {

  }
}
