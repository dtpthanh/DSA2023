import java.util.HashMap;

public class Bai_1 {
  public static void main(String[] args) {
    int[] input = {1, -2, 3, -1, 2, -4, 2, 3};
    System.out.println("Input array: ");
    printArray(input);

    int[] result = findMaxSubarraySum(input);
    System.out.println("Maximum subarray sum: " + result[0]);
    System.out.println("Subarray indices: [" + result[1] + ", " + result[2] + "]");
  }

  // Function to find the maximum subarray sum using Hash Table
  private static int[] findMaxSubarraySum(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxSum = 0;
    int currentSum = 0;
    int start = -1;
    int end = -1;

    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];

      if (currentSum == 0) {
        // Handle the case where the entire array is the maximum subarray
        start = 0;
        end = i;
        maxSum = currentSum + 1; // Set maxSum to a value greater than 0
      } else if (map.containsKey(currentSum)) {
        // Update maxSum and subarray indices if a sum is found in the Hash Table
        int prevIndex = map.get(currentSum);
        int subarraySum = currentSum - nums[prevIndex] + nums[i];
        if (subarraySum > maxSum) {
          start = prevIndex + 1;
          end = i;
          maxSum = subarraySum;
        }
      } else {
        // Store the current sum and its index in the Hash Table
        map.put(currentSum, i);
      }
    }

    return new int[]{maxSum, start, end};
  }

  // Helper function to print an array
  private static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
