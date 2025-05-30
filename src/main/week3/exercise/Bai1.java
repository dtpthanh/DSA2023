package main.week3.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Bai1 {

  // Do not instantiate.
  private Bai1() { }

  /**
   * Prints to standard output the (i, j, k) with {@code i < j < k}
   * such that {@code a[i] + a[j] + a[k] == 0}.
   *
   * @param a the array of integers
   */
  public static void printAll(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        for (int k = j+1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            StdOut.println(a[i] + " " + a[j] + " " + a[k]);
          }
        }
      }
    }
  }

  /**
   * Returns the number of triples (i, j, k) with {@code i < j < k}
   * such that {@code a[i] + a[j] + a[k] == 0}.
   *
   * @param  a the array of integers
   * @return the number of triples (i, j, k) with {@code i < j < k}
   *         such that {@code a[i] + a[j] + a[k] == 0}
   */
  public static int count(int[] a) {
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        for (int k = j+1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }

  /**
   * Reads in a sequence of integers from a file, specified as a command-line argument;
   * counts the number of triples sum to exactly zero; prints out the time to perform
   * the computation.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args)  {
    In in = new In(args[0]);
    int[] a = in.readAllInts();

    Stopwatch timer = new Stopwatch();
    int count = count(a);
    StdOut.println("elapsed time = " + timer.elapsedTime());
    StdOut.println(count);
  }
}
