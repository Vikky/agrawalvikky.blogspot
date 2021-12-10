package search;

public class RotatedArraySearch {
  public static void main(String[] args) {
    RotatedArraySearch obj = new RotatedArraySearch();

    int[] arr = new int[] {4, 5, 6, 7, 1, 2};

    int loc = obj.modifiedSearch(arr, 0, arr.length - 1, 3);
    System.out.println("Search location : " + loc);
  }

  /**
   * Algo : If array already sorted : apply binary search
   *
   * <p>else break array in 2 parts
   *
   * <p>one of which will be sorted for sure
   *
   * <p>if number lies in sorted range binary search on that
   *
   * <p>else recurse on other unsorted array.
   */
  public int modifiedSearch(int[] arr, int low, int end, int val) {

    if (!isRotated(arr, low, end)) {
      return binarySearch(arr, low, end, val);
    }

    // break array in two and recursively search
    int mid = (low + end) / 2;
    if (arr[mid] == val) return mid;

    // whether to go left or right?
    if (!isRotated(arr, low, mid - 1)) {
      if (isRange(arr, low, mid - 1, val)) return binarySearch(arr, low, mid - 1, val);
      else return modifiedSearch(arr, mid + 1, end, val);
    } else {
      if (isRange(arr, mid + 1, end, val)) return binarySearch(arr, mid + 1, end, val);
      else return modifiedSearch(arr, low, mid - 1, val);
    }
  }

  private boolean isRange(int[] arr, int low, int end, int val) {

    if (arr[low] == val || arr[end] == val || (val > arr[low] && val < arr[end])) return true;

    return false;
  }

  private boolean isRotated(int[] arr, int start, int end) {
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
