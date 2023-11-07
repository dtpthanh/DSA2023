package main.week9.hackerrank;

import com.sun.source.tree.Tree;
import javax.swing.tree.TreeNode;
import org.w3c.dom.Node;

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
  }
}
public class TreesInorderTraversal {
  public static void inOrder(TreeNode root) {
    if(root == null){
      return;
    }
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);

  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(5);
    root.right.right.left = new TreeNode(3);
    root.right.right.right = new TreeNode(6);
    root.right.right.left.right = new TreeNode(4);
    inOrder(root);
  }
}
