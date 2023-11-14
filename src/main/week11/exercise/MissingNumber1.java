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

public class MissingNumber1 {
  class Result {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
      //Hash Tables. Độ phức tạp O(n + m).
      Map<Integer, Integer> countMap = new HashMap<>();

      for (int num : arr) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      }

      for (int num : brr) {
        countMap.put(num, countMap.getOrDefault(num, 0) - 1);
      }

      List<Integer> result = new ArrayList<>();
      for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        if (entry.getValue() != 0) {
          result.add(entry.getKey());
        }
      }

      Collections.sort(result);
      return result;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int m = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.missingNumbers(arr, brr);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
