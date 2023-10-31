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

public class FindRunningMedian {
  class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
      // Write your code here
      List<Double> median = new ArrayList<>();
      PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> minPQ = new PriorityQueue<>();
      for (int n : a) {
        if (maxPQ.isEmpty() || n<maxPQ.peek()) {
          maxPQ.add(n);
        } else minPQ.add(n);

        if (Math.abs(maxPQ.size() - minPQ.size()) >= 2) {
          if (maxPQ.size() > minPQ.size()) {
            minPQ.add(maxPQ.poll());
          } else maxPQ.add(minPQ.poll());
        }

        if(minPQ.size() == maxPQ.size()) {
          median.add((double)(minPQ.peek() + maxPQ.peek()) / 2);
        } else if (maxPQ.size() > minPQ.size()) {
          median.add((double)maxPQ.peek());
        } else median.add((double)minPQ.peek());
      }
      return median;
    }

  }
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int aCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    List<Double> result = Result.runningMedian(a);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
