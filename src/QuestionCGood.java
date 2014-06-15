// this class can solve the QuestionCBad class's bug
public class QuestionCGood {

	public static class Result {
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
        
            /* If we're currently at p or q, and we also found one of those
             * nodes in a subtree, then this is truly an ancestor and the
             * flag should be true. */
             
            boolean isAncestor = rx.node != null || ry.node != null ? true : false;
            
            return new Result(root, isAncestor);
            
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }   

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
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
		// Case 1 :  p = 5 , q = 8 (regular)
	    //System.out.println(commonAncestorBad(tree, tree.left.left.right, tree.left.right).val);
		
		
	    // Case 2 :  p = 4, q = 3 (q is child of p)            lowest ancestor will be 4
	    System.out.println("q is child of p  :   "+commonAncestor(tree, tree.left.left, tree.left.left.left).val);
	    
	    // Case 3 :  p = 4, q = 20 (q is not in the tree)
	    System.out.println("q is not in the tree  :  "+commonAncestor(tree, tree.left.left, new TreeNode(20)));	    	   
    }
}
