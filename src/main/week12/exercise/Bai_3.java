package main.week12.exercise;

import java.util.HashSet;

public class Bai_3 {

  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  class LinkedList {

    Node head;

    public void removeDuplicates() {
      HashSet<Integer> seen = new HashSet<>();
      Node current = head;
      Node previous = null;

      while (current != null) {
        int data = current.data;
        if (seen.contains(data)) {
          previous.next = current.next;
        } else {
          seen.add(data);
          previous = current;
        }

        current = current.next;
      }
    }

    public void printList() {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Bai_3 bai3 = new Bai_3();
    LinkedList list = bai3.new LinkedList();
    list.head = bai3.new Node(1);
    list.head.next = bai3.new Node(2);
    list.head.next.next = bai3.new Node(3);
    list.head.next.next.next = bai3.new Node(2);
    list.head.next.next.next.next = bai3.new Node(4);
    list.head.next.next.next.next.next = bai3.new Node(1);
    list.head.next.next.next.next.next.next = bai3.new Node(5);
    System.out.print("LinkedList: ");
    list.printList();
    list.removeDuplicates();
    list.printList();
  }
}
