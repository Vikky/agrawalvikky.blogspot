package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * <p>We are playing a game with the stones. On each turn, we choose the heaviest two stones and
 * smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result
 * of this smash is:
 *
 * <p>If x == y, both stones are destroyed, and If x != y, the stone of weight x is destroyed, and
 * the stone of weight y has new weight y - x. At the end of the game, there is at most one stone
 * left.
 *
 * <p>Return the smallest possible weight of the left stone. If there are no stones left, return 0
 */
public class LastStone {

  public static void main(String[] args) {

    LastStone lastStone = new LastStone();
    int val = lastStone.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1});
    System.out.println("Last stone weight :" + val);
  }

  public int lastStoneWeight(int[] stones) {

    int length = stones.length;
    PriorityQueue<Integer> queue = new PriorityQueue(length, Comparator.reverseOrder());

    for (int val : stones) queue.offer(val);

    while (queue.size() > 1) {
      int y = queue.poll();
      int x = queue.poll();

      if (x != y) queue.offer(y - x);
    }

    if (queue.size() == 0) return 0;

    return queue.peek();
  }
}
