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

    public List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
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
          if (!result.contains(brr.get(j))) {
            result.add(brr.get(j));
          }
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
    MissingNumber2 missingNumber2 = new MissingNumber2();
    Result resultInstance = missingNumber2.new Result();

    Scanner scanner = new Scanner(System.in);

    int sizeArr = scanner.nextInt();
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < sizeArr; i++) {
      arr.add(scanner.nextInt());
    }

    int sizeBrr = scanner.nextInt();
    List<Integer> brr = new ArrayList<>();
    for (int i = 0; i < sizeBrr; i++) {
      brr.add(scanner.nextInt());
    }

    scanner.close();

    List<Integer> missingNumbers = resultInstance.missingNumbers(arr, brr);

    for (int i = 0; i < missingNumbers.size(); i++) {
      System.out.print(missingNumbers.get(i) + " ");
    }
  }
}
