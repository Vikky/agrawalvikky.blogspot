package heap;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest
 * element in the sorted order, not the kth distinct element.
 *
 * <p>Implement KthLargest class:
 *
 * <p>KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of
 * integers nums. int add(int val) Appends the integer val to the stream and returns the element
 * representing the kth largest element in the stream.
 *
 * <p>Input ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]], [3], [5], [10],
 * [9], [4]] Output [null, 4, 5, 5, 8, 8]
 *
 * Explanation KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); //return 4
 * kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5
 * kthLargest.add(9); //return 8
 * kthLargest.add(4); // return 8
 */
public class KthLargest {

  int k;
  PriorityQueue<Integer> queue;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    queue = new PriorityQueue<>();

    for (int i : nums) {
      queue.offer(i);
    }

    //    printQueue();
    //    System.out.println(queue.peek());
    //    System.out.println(queue.poll());

    while (queue.size() > k) queue.poll();
  }

  public static void main(String[] args) {
    KthLargest obj = new KthLargest(3, new int[] {4, 5, 8, 2});
  }

  public int add(int val) {
    queue.offer(val);

    if (queue.size() > k) queue.poll();

    return queue.peek();
  }

  private void printQueue() {
    queue.forEach(
        val -> {
          System.out.print(val + " ");
        });
    System.out.println();
  }
}
