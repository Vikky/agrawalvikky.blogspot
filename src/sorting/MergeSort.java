package sorting;

/** @author vikky.agrawal */
public class MergeSort {

  int[] arr;

  MergeSort() {
    arr = new int[] {5, 3, 1, 2, 9, 8};
  }

  /** @param args */
  public static void main(String[] args) {
    MergeSort obj = new MergeSort();
    obj.operate();
  }

  public void operate() {
    System.out.println("Array before sortings: ");
    printArray();
    mergeSort(arr, 0, 5);

    System.out.println("Sorted array : ");
    printArray();
  }


  // Dividing in 2 so, tree height could be O(logn) - So total TC - O(logn *n)
  public void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, start, end, mid);
    }
  }

  //O(n) operations (n is the number of elements) - worst case O(n)
  public void merge(int[] input, int start, int end, int mid) {
    int[] temp = new int[end - start + 1];
    int i = start, j = mid + 1, k = 0;

    while (i <= mid && j <= end) {
      if (input[i] <= input[j]) {
        temp[k] = input[i];
        k++;
        i++;
      } else {
        temp[k] = input[j];
        k++;
        j++;
      }
    }

    // if left subarray has some elements
    while (i <= mid) {
      temp[k] = input[i];
      k++;
      i++;
    }

    // if right subarray has some elements
    while (j <= end) {
      temp[k] = input[j];
      k++;
      j++;
    }

    // Copy in original array
    int index = 0;
    for (int x = start; x <= end; x++) {
      input[x] = temp[index];
      index++;
    }
  }

  public void printArray() {
    for (int a : arr) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
