package main.week5.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class BalanceBrackets {
  class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
      // Write your code here
      Stack<Character> stack = new Stack<>();
      for(char c : s.toCharArray()) {
        if(c=='(' || c=='{' || c=='[') {
          stack.push(c);
        } else if(c==')' || c=='}' || c==']') {
          if(stack.isEmpty()) {
            return "NO";
          }
          char top = stack.pop();
          if(c==')' && top!='('   ||
              c=='}' && top!='{'  ||
              c==']' && top!='[') {
            return "NO";
          }
        }
      }
      return stack.isEmpty() ? "YES" : "NO";
    }

  }
  public static void main(String[] args) throws IOException {
  }
}
