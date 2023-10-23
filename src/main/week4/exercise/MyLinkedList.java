
public class MyLinkedList {

  static class Node {

    String data;
    Node next;

    public Node(String data) {
      this.data = data;
      this.next = null;
    }
  }

  static class SinglyLinkedList {

    public Node head;

    public SinglyLinkedList() {
      this.head = null;
    }

    public void insertNode(String data) {
      Node node = new Node(data);
      if (head == null) {
        head = node;
      } else {
        Node cur = head;
        while (cur.next != null) {
          cur = cur.next;
        }
        cur.next = node;
      }
    }

    public Node append(String data, Node head) {
      Node node = new Node(data);
      if (head == null) {
        return head = node;
      } else {
        Node cur = head;
        if (cur.next == null) {
          return cur.next = node;
        } else {
          return append(data, cur.next);
        }
      }
    }
  }

  public static void printLinkedList(Node head) {
    if (head == null) {
      return;
    }
    System.out.println(head.data);
    printLinkedList(head.next);
  }

  public static void main(String[] main) {
    SinglyLinkedList llist = new SinglyLinkedList();
    llist.insertNode("1");
    llist.insertNode("2");
    llist.append("3",llist.head);
    printLinkedList(llist.head);
  }
}
