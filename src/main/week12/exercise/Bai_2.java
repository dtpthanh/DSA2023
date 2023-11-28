package main.week12.exercise;

import java.util.*;

public class Bai_2 {
  public static void findPairsWithSum(int[] arr, int targetSum) {
    Map<Integer, Integer> seenNumbers = new HashMap<>();
    for (int num : arr) {
      int complement = targetSum - num;
      if (seenNumbers.containsKey(complement)) {
        System.out.println("(" + complement + ", " + num + ")");
      }
      seenNumbers.put(num, 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int targetSum = 10;
    System.out.println("Pairs with sum " + targetSum + " :");
    findPairsWithSum(arr, targetSum);
  }
}
