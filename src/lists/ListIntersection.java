package lists;

import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class ListIntersection {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(5);

        ListNode tmp = head1;
        populate(tmp, Arrays.asList(1, 5, 2, 3));

        tmp = head2;
        populate(tmp, Arrays.asList(2, 3));

        printList(head1);
        printList(head2);

        ListIntersection listIntersection = new ListIntersection();
        ListNode intersection = listIntersection.getIntersectionNode(head1, head2);
        printList(intersection);
    }

    private static void populate(ListNode tmp, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
    }


    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) {
            return null;
        }

        int l1 = length(head1);
        int l2 = length(head2);

        if (l1>l2)
        {
            int length = l1-l2;
            while(head1!=null && length>0)
            {
                head1= head1.next;
                length--;
            }
        }

        if (l2>l1)
        {
            int length = l2-l1;
            while(head2!=null && length>0)
            {
                head2 = head2.next;
                length--;
            }
        }

        boolean flag = false;
        ListNode intersection = null;

        while (!flag) {
            if (head1 == null || head2 == null)
                break;

            while (head1 != null && head2 != null && head1.val != head2.val) {
                head1 = head1.next;
                head2 = head2.next;
            }

            intersection = head1;

            while (head1 != null && head2 != null) {
                if (head1.val != head2.val) {
                    flag = false;
                    intersection = null;
                    break;
                } else
                    flag = true;

                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return intersection;
    }

    private int length(ListNode node) {
        if (node == null)
            return 0;

        int i = 1;
        while (node.next != null) {
            i++;
            node = node.next;
        }

        return i;
    }

    private static void printList(ListNode list)
    {
        while (list!=null)
        {
            System.out.print(list.val+" ");
            list = list.next;
        }
        System.out.println();
    }

}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}