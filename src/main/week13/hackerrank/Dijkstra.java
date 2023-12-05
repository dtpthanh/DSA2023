package main.week13.hackerrank;

import java.util.*;

public class Dijkstra {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    while (t-- > 0) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      List<int[]>[] a = new ArrayList[n + 1];
      for (int i = 1; i <= n; i++) {
        a[i] = new ArrayList<>();
      }

      for (int i = 0; i < m; i++) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        a[x].add(new int[]{y, z});
        a[y].add(new int[]{x, z});
      }

      int s = scanner.nextInt();

      int[] distance = new int[n + 1];
      Arrays.fill(distance, 1000000);
      distance[s] = 0;

      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
      pq.add(new int[]{0, s});

      while (!pq.isEmpty()) {
        int[] x = pq.poll();
        if (x[0] > distance[x[1]]) continue;
        for (int[] child : a[x[1]]) {
          if (distance[child[0]] > distance[x[1]] + child[1]) {
            distance[child[0]] = distance[x[1]] + child[1];
            pq.add(new int[]{distance[x[1]] + child[1], child[0]});
          }
        }
      }

      List<Integer> ans = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        if (i == s) continue;
        if (distance[i] == 1000000)
          ans.add(-1);
        else
          ans.add(distance[i]);
      }

      for (int i = 0; i < ans.size(); i++) {
        System.out.print(ans.get(i) + " ");
      }
      System.out.println();
    }
  }
}
