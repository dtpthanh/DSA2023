package main.week10.hackerrank;

import java.util.*;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class BinarySearchTreeInsertion {

  public static void preOrder( Node root ) {

    if( root == null)
      return;

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);

  }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

  public static Node insert(Node root,int data) {
    if (root == null)
      return new Node(data);
    Node current = root;
    Node node = new Node(data);
    while (true) {
      if (data <= current.data) {
        if (current.left == null) {
          current.left = node;
          break;
        }
        current = current.left;
      }
      if (data > current.data) {
        if (current.right == null) {
          current.right = node;
          break;
        }
        current = current.right;
      }
    }
    return root;

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while(t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    preOrder(root);
  }
}