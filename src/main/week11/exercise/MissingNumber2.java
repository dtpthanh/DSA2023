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
public class MissingNumber2 {
  class Result {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
      //Sorting. Độ phức tạp O(n * log(n) + m * log(m)).
      Collections.sort(arr);
      Collections.sort(brr);

      List<Integer> result = new ArrayList<>();
      int i = 0, j = 0;

      while (i < arr.size() && j < brr.size()) {
        if (arr.get(i).equals(brr.get(j))) {
          i++;
          j++;
        } else {
          result.add(brr.get(j));
          j++;
        }
      }
      while (j < brr.size()) {
        result.add(brr.get(j));
        j++;
      }

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
