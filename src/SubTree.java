
public class SubTree {

	    public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) 
			return true; // The empty tree is always a subtree
		else 
			return subTree(t1, t2);
		}

	   static boolean subTree(TreeNode r1, TreeNode r2) {
			if (r1 == null)
				return false; // big tree empty & subtree still not found.
			if (r1.val == r2.val) {
				if (matchTree(r1,r2)) 
					return true;
			}
			return (subTree(r1.left, r2) || subTree(r1.right, r2));
		}

	   static boolean matchTree(TreeNode r1, TreeNode r2) {
			if (r2 == null && r1 == null)
				return true; // nothing left in the subtree
			if (r1 == null || r2 == null)
				return false; // big tree empty & subtree still not found
			if (r1.val != r2.val)
				return false; // data doesn't match
			return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
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
			
			
			TreeNode tree2 = new TreeNode(4);
			tree2.left = new TreeNode(3);
			tree2.right = new TreeNode(5);
			
			System.out.println(containsTree(tree, tree2));
		}
}
