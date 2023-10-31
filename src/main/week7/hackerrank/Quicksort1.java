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



public class Quicksort1 {
  class Result {

  /*
   * Complete the 'quickSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
      int equal = arr.get(0);
      List<Integer> left = new ArrayList<>();
      List<Integer> right = new ArrayList<>();
      for (int i = 1; i < arr.size(); i++) {
        int value = arr.get(i);
        if (value < equal) left.add(value);
        else right.add(value);
      }
      left.add(equal);
      left.addAll(right);
      return left;
    }
  }
  public static void main(String[] args) throws IOException {

  }
}
