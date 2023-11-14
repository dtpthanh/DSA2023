package main.week9.hackerrank;

import com.sun.source.tree.Tree;
import javax.swing.tree.TreeNode;
import org.w3c.dom.Node;


public class TreesInorderTraversal {
  class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.data = data;
    }
  }
  public static void inOrder(TreeNode root) {
    if(root == null){
      return;
    }
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);

  }
  public static void main(String[] args) {

  }
}
