import java.io.*;
import java.util.*;

public class SimpleTextEditor {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int Q = scanner.nextInt();
    String text = "";
    Stack<String> stack = new Stack<>();

    for(int i=0; i<Q; i++) {
      int num = scanner.nextInt();
      switch(num) {
        //append
        case 1:
          stack.push(text);
          String append = scanner.next();
          text += append;
          break;
        //delete
        case 2:
          stack.push(text);
          int k = scanner.nextInt();
          String newText = text.substring(0, text.length()-k);
          text = newText;
          break;
        //print
        case 3:
          int m = scanner.nextInt();
          System.out.println(text.charAt(m-1));
          break;
        //undo
        case 4:
          if(!stack.isEmpty()) {
            String undo = stack.pop();
            text = undo;
          }
          break;
      }
    }
    scanner.close();
  }
}
