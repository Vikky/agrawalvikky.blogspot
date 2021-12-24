package binarysearch;

public class RotatedArraySearch {
  public static void main(String[] args) {
    RotatedArraySearch obj = new RotatedArraySearch();

    int[] arr = new int[] {8, 9, 2, 3, 4};

    int loc = obj.onepassSearch(arr, 9);
    System.out.println("Search location : " + loc);
  }

  private int onepassSearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] == target) return mid;
      // if left is sorted.
      else if (arr[mid] > arr[start]) {
        if (target >= arr[start] && target < arr[mid]) end = mid - 1;
        else start = mid + 1;
      } else {
        if ( target > arr[mid] && target <= arr[end])
          start = mid+1;
        else
          end=mid-1;
      }
    }
    return -1;
  }

  /**
   * Algo : If array already sorted : apply binary search Find pivot element :<br>
   * Smallest element will be pivot element<br>
   * Use binary search to identify pivot
   */
  public int modifiedSearch(int[] arr, int low, int end, int val) {

    if (!isRotated(arr, low, end)) return binarySearch(arr, low, end, val);
    int pivot = find_rotated_index(arr, low, end);
    if (arr[pivot] == val) return pivot;

    // Target will be either in left of pivot or right of pivot
    // Do binary search on it.
    if (inRange(arr, low, pivot - 1, val)) return binarySearch(arr, low, pivot - 1, val);
    else return binarySearch(arr, pivot + 1, end, val);
  }

  private boolean inRange(int[] arr, int low, int end, int val) {
    return val >= arr[low] && val <= arr[end];
  }

  private int find_rotated_index(int[] arr, int low, int end) {
    if (low == end || arr[low] < arr[end]) return low;

    while (low <= end) {
      int pivot = (low + end) / 2;
      if (arr[pivot] > arr[pivot + 1]) return pivot + 1;
      else {
        if (arr[pivot] < arr[low]) end = pivot - 1;
        else low = pivot + 1;
      }
    }
    return 0;
  }

  /**
   * Pivot element is element whose previous is greater than it <br>
   * Check for mid-element if this condition satisfies <br>
   * check for mid+1 element if that is less than mid <br>
   * return if true; <br>
   * else
   */
  private int findPivot(int[] arr, int low, int end) {

    if (end < low) return arr[0];

    if (low == end) return arr[low];

    int mid = (low + end) / 2;

    if (mid > low && arr[mid] < arr[mid - 1]) return mid;

    if (mid < end && arr[mid + 1] < arr[mid]) return mid + 1;

    if (arr[mid] < arr[end]) return findPivot(arr, low, mid - 1);
    return findPivot(arr, mid + 1, end);
  }

  private boolean isRotated(int[] arr, int start, int end) {
    if (start == end || end < start) return false;
    if (arr[start] < arr[end]) return false;
    return true;
  }

  private int binarySearch(int[] arr, int low, int end, int val) {
    if (low <= end) {
      int mid = (low + end) / 2;

      if (arr[mid] == val) return mid;

      if (val < arr[mid]) return binarySearch(arr, low, mid - 1, val);
      else return binarySearch(arr, mid + 1, end, val);
    }
    return -1;
  }
}
