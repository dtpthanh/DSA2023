
import java.util.HashMap;

public class Bai_1 {

  public static int findMaxSubsequenceSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
    int maxSum = 0;
    int currentSum = 0;

    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];

      if (currentSum <= 0) {
        currentSum = 0;
        sumIndexMap.clear();
        sumIndexMap.put(0, i + 1);
      } else {
        if (!sumIndexMap.containsKey(currentSum)) {
          sumIndexMap.put(currentSum, i);
        }

        if (currentSum > maxSum) {
          maxSum = currentSum;
        }
      }
    }

    if (maxSum == 0) {
      int maxNegative = Integer.MIN_VALUE;
      for (int num : nums) {
        if (num > maxNegative) {
          maxNegative = num;
        }
      }
      return maxNegative;
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] input = {1, -2, 3, -1, 2, -4, 2, 3};
    int result = findMaxSubsequenceSum(input);
    System.out.println(result);
  }
}