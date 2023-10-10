package main.week6.exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {
  public static void selectionSort(int[] arr) {
    for(int i=0; i<arr.length; i++) {
      for(int j=i+1; j< arr.length; j++)
        if (arr[i] > arr[j]) {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
    }
  }

  public static void main(String[] args) {
    int n = StdIn.readInt();
    int[] a = new int[n];
    for(int i=0; i<n; i++) {
      a[i] = StdIn.readInt();
    }
    selectionSort(a);
    for (int i=0; i<n; i++) {
      StdOut.print(a[i]+" ");
    }
  }
}
