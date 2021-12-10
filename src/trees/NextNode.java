package trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextNode {

    public Node connect(Node root) {

        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList();
        queue.add(root);


        // Since the given tree is complete binary tree
        // Do a level order traversal and connect each node with its next node.
        // If no next then set next to null;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- >0)
            {
                Node node = queue.poll();
                Node next = queue.peek();
                node.next = next;

                queue.add(node.left);
                queue.add(node.right);
            }

        }

        return root;

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


}
