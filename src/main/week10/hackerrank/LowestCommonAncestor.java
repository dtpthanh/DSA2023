import java.util.*;

class LowestCommonAncestor {

  static class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
  public static Node lca(Node root, int v1, int v2) {
    // Write your code here.
    if (root == null) {
      return null;
    }

    if (v1 < root.data && v2 < root.data) {
      return lca(root.left, v1, v2);
    } else if (v1 > root.data && v2 > root.data) {
      return lca(root.right, v1, v2);
    } else {
      // If v1 and v2 are on different sides of the current root, or if one of them matches the root's value,
      // then the current root is the lowest common ancestor.
      return root;
    }

  }

  public static Node insert(Node root, int data) {
    if(root == null) {
      return new Node(data);
    } else {
      Node cur;
      if(data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while(t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    int v1 = scan.nextInt();
    int v2 = scan.nextInt();
    scan.close();
    Node ans = lca(root,v1,v2);
    System.out.println(ans.data);
  }
}