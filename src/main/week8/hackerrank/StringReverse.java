import java.io.*;
import java.util.*;

public class StringReverse {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scanner = new Scanner(System.in);
      String a = scanner.next();
      String result = "";
      for (int i = a.length()-1; i >= 0; i--) {
        char b = a.charAt(i);
        result += b;
      }
      String kq = a.equals(result) ? "YES" : "NO";
      System.out.println(kq);
  }
}