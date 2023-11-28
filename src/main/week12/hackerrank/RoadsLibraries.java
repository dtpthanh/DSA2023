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

public class RoadsLibraries {
  class Result {

  /*
   * Complete the 'roadsAndLibraries' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER c_lib
   *  3. INTEGER c_road
   *  4. 2D_INTEGER_ARRAY cities
   */

  public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
    // Write your code here
    if(c_lib <= c_road){
      return (long)n * c_lib;
    }

    int[] parents = new int[n];
    for(int i = 0;i < n;i++){
      parents[i] = i;
    }

    for(List<Integer> city : cities){
      int c1 = city.get(0) - 1;
      int c2 = city.get(1) -1;

      add2Union(parents,c1,c2);
    }

    Map<Integer,Integer> groupCount = new HashMap<>();
    for(int p : parents){
      int parent = findParent(parents,p);
      groupCount.put(parent,groupCount.getOrDefault(parent,0)+1);
    }

    long res = 0;
    for(Map.Entry<Integer,Integer> e : groupCount.entrySet()){
      res += c_lib;
      res += (long)(e.getValue() - 1) * c_road;
    }

    return res;
  }

  public static void add2Union(int[] parents,int c1,int c2){

    int p1 = findParent(parents,c1);
    int p2 = findParent(parents,c2);
    if(p1 == p2){
      return;
    }
    parents[p2] = p1;
  }

  public static int findParent(int[] parents,int c){
    if(parents[c] == c){
      return c;
    }
    int p = findParent(parents,parents[c]);
    parents[c] = p;
    return p;
  }

}

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int c_lib = Integer.parseInt(firstMultipleInput[2]);

        int c_road = Integer.parseInt(firstMultipleInput[3]);

        List<List<Integer>> cities = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
          try {
            cities.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
