
public class StackandQueue {
  public static class Node{
    String item;
    Node next;
  }

  public static class Stack{
    private Node first = null;
    public boolean isEmpty() {
      return first==null;
    }
    public void push(String item) {
      Node old = first;
      first = new Node();
      first.item = item;
      first.next = old;
    }
    public String pop() {
      String result = first.item;
      first = first.next;
      return result;
    }
    public String peek() {
      String result = first.item;
      return result;
    }


    public static class Queue{
      private Node first, last;
      public boolean isEmpty() {
        return first==null;
      }
      public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
      }
      public String dequeue() {
        String result = first.item;
        first = first.next;
        return result;
      }
    }

    public static class Queue2{
      Stack stack1 = new Stack();
      Stack stack2 = new Stack();
      public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
      }
      public void enqueue(String item) {
        stack1.push(item);
      }
      public String dequeue() {
        if(stack2.isEmpty()) {
          while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
          }
        }
        return stack2.pop();
      }
    }

    public static void main(String[] args) {
      Stack stack = new Stack();
      stack.push("a");
      stack.push("b");
      stack.push("c");
      while(!stack.isEmpty())
        System.out.println(stack.pop());
      Queue queue = new Queue();
      queue.enqueue("1");
      queue.enqueue("2");
      queue.enqueue("3");
      while (!queue.isEmpty())
        System.out.println(queue.dequeue());
      Queue2 q1 = new Queue2();
      q1.enqueue("A");
      q1.enqueue("B");
      q1.enqueue("C");
      while (!q1.isEmpty())
        System.out.println(q1.dequeue());
    }
  }
}