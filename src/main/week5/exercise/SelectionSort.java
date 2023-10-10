package main.week5.exercise;

import java.util.Scanner;

public class SelectionSort {
  public static void selectionSort(int[] a) {
    int n = a.length;
    for (int i=0; i<n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] > a[j]) {
          int tmp = a[i];
          a[i] = a[j];
          a[j] = tmp;
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i=0; i<n; i++) {
      a[i] = scanner.nextInt();
    }
    long start = System.currentTimeMillis();
    selectionSort(a);
    long end = System.currentTimeMillis();
    for (int i=0; i<n; i++) {
      System.out.println(a[i]);
    }
    System.out.println("Thoi gian chay: " + start);
  }
}
