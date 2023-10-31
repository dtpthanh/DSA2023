import edu.princeton.cs.algs4.In;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class JesseCookies {
  class Result {

  /*
   * Complete the 'cookies' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY A
   */

  public static int cookies(int k, List<Integer> A) {
    // Write your code here
    PriorityQueue<Integer> arr = new PriorityQueue<>(A);
    int cnt = 0;
    while (arr.size() > 1 && arr.peek() < k) {
      int a = arr.poll();
      int b = arr.poll();
      arr.offer(a+2*b);
      cnt++;
    }
    if (arr.peek()>=k) return cnt;
    return -1;
  }

}
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.cookies(k, A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
