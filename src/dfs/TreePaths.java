package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */




public class TreePaths
{

//sum =28
		/**
	 * 
	 * 
	 * 		12
	 * 	  7    1
	 *  9	 15	5	
	 * 			 10	
	 * 
	 **/


//12, 7, 9

public static void main(String[] args)
	{
		Node root = new Node(12);
		root.left = new Node(7);
		root.right = new Node(1);
		
		root.left.left = new Node(9);

		root.right.left = new Node(15);
		root.right.right = new Node(5);
        
        root.right.right.right = new Node(10);

		TreePaths obj = new TreePaths();
		int number =28;
		System.out.println("number of paths : "+obj.numberOfPaths(root, number).size());


	}


	// for each node check if path exists to its left and right subtree, if path exists add in list.


public List<List<Integer>> numberOfPaths(Node node, int sum)
	{

		if (node==null || sum==0 || sum<0) {
			return null;
		}
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> current = new ArrayList<Integer>();

		findPath(node, sum, current, allPaths);

        return allPaths;
	}

	private void findPath(Node node, int sum, List<Integer> current, List<List<Integer>> allPaths)
	{
		if (node==null) {
			return;
		}

		current.add(node.val);

		if (sum - node.val ==0 && node.left ==null && node.right ==null) {
			allPaths.add(current);
		}
		else 
		{
			findPath(node.left, sum-node.val, current, allPaths);
			findPath(node.right, sum-node.val, current, allPaths);
		}
	
		current.remove(current.size()-1);

	}

	private static class Node
	{
		Node left;
		Node right;
		int val;
        
        Node(int val)
        {
            this.val=val;
        }
	}



}




