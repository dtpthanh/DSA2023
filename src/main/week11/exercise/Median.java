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

public class Median {
  static class TreeNode {
    int val;
    int count;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
      this.count = 1;
      this.left = this.right = null;
    }
  }

  static class BST {
    private TreeNode root;

    public void insert(int val) {
      root = insertNode(root, val);
    }

    static private TreeNode insertNode(TreeNode node, int val) {
      if (node == null) {
        return new TreeNode(val);
      }

      if (val < node.val) {
        node.left = insertNode(node.left, val);
      } else {
        node.right = insertNode(node.right, val);
      }

      node.count++;
      return node;
    }

    public double findMedian() {
      int totalNodes = root.count;
      if (totalNodes % 2 == 1) {
        return findKthSmallest(root, totalNodes / 2 + 1);
      } else {
        double left = findKthSmallest(root, totalNodes / 2);
        double right = findKthSmallest(root, totalNodes / 2 + 1);
        return (left + right) / 2;
      }
    }

    private double findKthSmallest(TreeNode node, int k) {
      int leftCount = (node.left != null) ? node.left.count : 0;

      if (k == leftCount + 1) {
        return node.val;
      } else if (k <= leftCount) {
        return findKthSmallest(node.left, k);
      } else {
        return findKthSmallest(node.right, k - leftCount - 1);
      }
    }
  }

  class Result {
    public static List<Double> runningMedian(List<Integer> a) {
      List<Double> median = new ArrayList<>();
      BST bst = new BST();

      for (int n : a) {
        bst.insert(n);
        median.add(bst.findMedian());
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
