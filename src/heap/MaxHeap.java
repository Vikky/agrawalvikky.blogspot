package heap;

public class MaxHeap {

  int[] arr = {10, 5, 3, 2, 4};
  int size = 5;

  public static void main(String[] args) {

    MaxHeap obj = new MaxHeap();

    int max = obj.getMax();
    System.out.println("Max right now :" + max);

    obj.print(obj.arr);

    max = obj.getMax();
    System.out.println("Max right now :" + max);

    obj.print(obj.arr);

    obj.insert(15);
    obj.print(obj.arr);
  }

  private void heapify(int[] arr, int i, int size) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && arr[left] > arr[largest]) largest = left;

    if (right < size && arr[right] > arr[largest]) largest = right;

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, largest, size);
    }
  }

  private void insert(int num) {
    arr[size] = num;
    size++;
    if (size != 1) {
       heapifyBottom(arr, size-1, size);
    }
  }

  private void heapifyBottom(int[] arr, int i, int size) {
    int parent = getParent(i);
    if (parent >= 0) {
      if (arr[i] > arr[parent]) {
        swap(arr, i, parent);
        heapifyBottom(arr, parent, size);
      }
    }
  }

  private int getMax() {
    if (size == 0) return -1;
    int val = arr[0];
    swap(arr, 0, size - 1);
    size--;
    heapify(arr, 0, size);
    return val;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private int getParent(int pos) {
    return (pos - 1) / 2;
  }

  private void print(int[] arr) {
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
