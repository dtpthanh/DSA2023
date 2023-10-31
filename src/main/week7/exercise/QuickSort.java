
public class QuickSort {
  public static int[] quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);
      quickSort(arr, low, pivotIndex);
      quickSort(arr, pivotIndex, high);
      return arr;
    }
    return arr;
  }

  public static int partition(int[] arr, int low, int hight) {
    int pivot = arr[low];
    int i = low - 1;
    int j = hight - 1;
    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);

      do {
        j--;
      } while (arr[j] > pivot);

      if (i == j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      } else return j;
    }
  }

  public static void main(String[] args) {

  }
}
