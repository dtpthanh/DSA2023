
public class MergeSort {
  public static int[] mergeSort(int[] arr) {
    int n = arr.length;
    if (n <= 1) {
      return arr;
    }

    int mid = n/2;
    int[] left = new int[mid];
    int[] right = new int[n - mid];

    for (int i=0; i<mid; i++) {
      left[i] = arr[i];
    }
    for (int i=mid; i<n; i++) {
      right[mid-i] = arr[i];
    }

    left = mergeSort(left);
    right = mergeSort(right);
    return merge(left, right);
  }

  public static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i=0, j=0, k=0;
    while (i<left.length && j<right.length) {
      if (left[i] < right[i]) {
        result[k] = left[i];
        i++;
      } else {
        result[k] = right[j];
        j++;
      }
      k++;
    }

    while (i<left.length) {
      result[k] = left[i];
      i++;
      k++;
    }

    while (j<right.length) {
      result[k] = right[j];
      j++;
      k++;
    }
    return result;
  }

  public static void main(String[] args){

  }
}
