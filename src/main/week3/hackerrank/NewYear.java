import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int n = q.size();
        int cnt = 0;
        boolean flag = false;
        for(int i=n-1; i>=0; i--) {
            if(q.get(i)-i-1>2) {
                flag=true;
                System.out.println("Too chaotic");
                return;
            }
            for(int j=Math.max(0,q.get(i)-2); j<i; j++) {
                if(q.get(j) > q.get(i)) {
                    cnt++;
                }
            }
        }
        if(flag==false) {
            System.out.println(cnt);
        }
    }
}

public class NewYear {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
