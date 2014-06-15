/*
 * You are given a binary tree in which each node contains a value Design an algorithm to print all paths which sum up to that value. 
    Note that a path can start or end anywhere in the tree.
 */
import java.lang.Math;
public class SumTreePath {
	public static void findSum(TreeNode node, int sum, int[] path, int level)
	{
		if(node == null)
			return;
		// insert current node into path
		path[level] = node.val;
		
		// look for paths with a sum that ends at this node.
		int t = 0;
		for(int i = level; i>=0 ; i--){
			t = t + path[i];
			if(t == sum)
				print(path, i, level);
		}
		// search nodes beneath this one.
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		// remove current node from path. Not strictly necessary,
		// since we would ignore this value, but it's a good practice.
		path[level] = Integer.MIN_VALUE;
	}
	
	public static void findSum(TreeNode node, int sum)
	{
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	public static void print(int[] path, int start, int end)
	{
		for(int i = start; i<= end ;i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	
	// find the deepest level  
	public static int depth(TreeNode node)
	{
		if(node == null)
			return 0;
		else
			return 1 + Math.max(depth(node.left), depth(node.right));		
	}

	public static void main(String[] args) {
    	/*    Unbalanced Tree
		 *               9
		 *           6       15
		 *        4    8
		 *      3   5
		 */
		TreeNode tree = new TreeNode(9);
		tree.left = new TreeNode(6);
		tree.left.left= new TreeNode(4);
		tree.left.left.left = new TreeNode(3);
		tree.left.left.right = new TreeNode(5);
		tree.left.right = new TreeNode(8);
		tree.right = new TreeNode(15);
		
		findSum(tree, 14);
	}
}
