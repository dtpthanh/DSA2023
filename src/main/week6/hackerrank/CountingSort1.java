import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class CountingSort1 {
  class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
      // Write your code here
      int[] cnt = new int[100];
      for(int i=0; i<arr.size(); i++) {
        cnt[arr.get(i)]++;
      }
      List<Integer> list = new ArrayList<>();
      for(int i=0; i<100; i++) {
        list.add(cnt[i]);
      }
      return list;
    }

  }
  public static void main(String[] args) throws IOException {
  }
}
