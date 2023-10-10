import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class InsertionSort2 {
  class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
      // Write your code here
      for(int i=1; i<n; i++) {
        int tmp = arr.get(i);
        int j;
        for(j=i-1; j>=0 && arr.get(j) > tmp; j--) {
          arr.set(j+1, arr.get(j));
        }
        arr.set(j+1, tmp);
        for(int k=0; k<n; k++) {
          System.out.print(arr.get(k)+" ");
        }
        System.out.println();
      }
    }

  }
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    Result.insertionSort2(n, arr);

    bufferedReader.close();
  }
}
