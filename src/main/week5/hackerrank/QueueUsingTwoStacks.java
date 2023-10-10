import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Queue<Integer> queue = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    for(int i=0; i<n; i++) {
      int a = scanner.nextInt();
      switch(a) {
        case 1:
          int b = scanner.nextInt();
          queue.add(b);
          break;
        case 2:
          if(!queue.isEmpty()) {
            queue.poll();
          }
          break;
        case 3:
          if(!queue.isEmpty()) {
            System.out.println(queue.peek());
          }
          break;
      }
    }
  }
}
