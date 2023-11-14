import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {
  public static int pairs(int[] arr, int n, int k) {
    int count = 0;
    //
    Set<Integer> values = new HashSet<>();

    for (int i = 0; i < n; i++) {
      int target1 = arr[i] - k;
      int target2 = arr[i] + k;

      if (values.contains(target1)) {
        count++;
      }
      if (values.contains(target2)) {
        count++;
      }

      values.add(arr[i]);
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(pairs(arr, n, k));
  }
}
