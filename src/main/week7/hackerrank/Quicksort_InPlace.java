
import static java.util.Collections.swap;

import edu.princeton.cs.algs4.Quick;
import java.io.*;
import java.util.*;

public class Quicksort_InPlace {
  public static int partition(List<Integer> arr, int low, int high) {
    int pivot = arr.get(high);
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr.get(j) < pivot) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr,i,high);
    for (int j=0; j<arr.size(); j++) {
      System.out.print(arr.get(j)+" ");
    }
    System.out.println();
    return i;
  }
  public static void quickSort(List<Integer> arr, int low, int high) {
    if(low < high) {
      int tmp = partition(arr, low, high);
      quickSort(arr, low, tmp - 1);
      quickSort(arr, tmp+1, high);
    }
  }
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List <Integer> arr = new ArrayList<>();
    for (int i=0; i<n; i++) {
      int num = scanner.nextInt();
      arr.add(num);
    }
    quickSort(arr, 0, arr.size()-1);
  }
}