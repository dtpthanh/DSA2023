import java.util.Scanner;
import java.util.Vector;

class ConnectedCell {
  public static int solve(int i, int j, int n, int m, Vector<Vector<Integer>> a) {
    if (i < 0 || j < 0 || i >= n || j >= m || a.get(i).get(j) == 0) {
      return 0;
    }
    a.get(i).set(j, 0);
    int r, t, y, f, h, c, v, b;
    r = solve(i - 1, j - 1, n, m, a);
    t = solve(i - 1, j, n, m, a);
    y = solve(i - 1, j + 1, n, m, a);
    f = solve(i, j - 1, n, m, a);
    h = solve(i, j + 1, n, m, a);
    c = solve(i + 1, j - 1, n, m, a);
    v = solve(i + 1, j, n, m, a);
    b = solve(i + 1, j + 1, n, m, a);
    return 1 + r + t + y + f + h + c + v + b;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    Vector<Vector<Integer>> a = new Vector<>();

    for (int i = 0; i < n; i++) {
      Vector<Integer> temp = new Vector<>();
      for (int j = 0; j < m; j++) {
        int op = scanner.nextInt();
        temp.add(op);
      }
      a.add(temp);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a.get(i).get(j) == 1) {
          int d = 0;
          d = solve(i, j, n, m, a);
          ans = Math.max(ans, d);
        }
      }
    }

    System.out.println(ans);
  }
}
