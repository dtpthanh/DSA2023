import java.io.*;
import java.util.*;



public class InsertionSort1 {
  class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
      // Write your code here
      for (int i = 1 ; i<n; i++) {
        int tmp = arr.get(i);
        int j;
        for(j=i-1;j>=0 && arr.get(j) > tmp; j--) {
          arr.set(j+1, arr.get(j));
          for(int k=0; k<n; k++) {
            System.out.print(arr.get(k)+" ");
          }
          System.out.println();
        }
        arr.set(j+1, tmp);
      }
      for(int i=0; i<n; i++) {
        System.out.print(arr.get(i)+" ");
      }
      System.out.println();
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

    Result.insertionSort1(n, arr);

    bufferedReader.close();
  }
}
