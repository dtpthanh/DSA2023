package main.week6.exercise;

import edu.princeton.cs.algs4.StdIn;
import java.util.Scanner;

public class InsertionSort {
  public static void insertionSort(int[] arr) {
    for (int i=0; i < arr.length; i++) {
      int tmp = arr[i];
      int j = i-1;
      while (j >= 0 && arr[j] > tmp) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = tmp;
    }
    for (int i=0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  public static void main(String[] args) {
    int n = StdIn.readInt();
    int[] a = new int[n];
    for (int i=0; i<n; i++) {
      a[i] = StdIn.readInt();
    }
    insertionSort(a);
  }
}
