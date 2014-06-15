public class QuestionCBad {
	    /* the commeonAncestorBad function has a bug. It couldn't distinguish between the two cases.
	     *  Case 2 and Case 3
	     */
        public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q) {
                if (root == null) {
                        return null;
                }
                if (root == p && root == q) {// found
                        return root;
                }
                
                TreeNode x = commonAncestorBad(root.left, p, q);
                if (x != null && x != p && x != q) { // Found common ancestor
                        return x;
                }
                
                TreeNode y = commonAncestorBad(root.right, p, q);
                if (y != null && y != p && y != q) {
                        return y;
                }
                
                if (x != null && y != null) {
                        return root; // This is the common ancestor
                } else if (root == p || root == q) {
                        return root;
                } else {
                        return x == null ? y : x;
                }
        }   
        
        // for find the lowest ancestor in BST
        public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        	  if (root == null || root.val == p.val || root.val == q.val) 
        		  return null;
        	  if ((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) 
        		  return root;
        	  if (root.val > p.val && root.val > q.val) 
        		  return LCA(root.left, p, q);
        	  if (root.val < p.val && root.val < q.val) 
        		  return LCA(root.right, p, q);
			return null;
        }
        
        // wrong the source from Leetcode
        public static TreeNode LCA2(TreeNode root, TreeNode p, TreeNode q) {
        	  if (root == null) return null;
        	  if (root == p || root == q) return root;
        	  TreeNode L = LCA(root.left, p, q);
        	  TreeNode R = LCA(root.right, p, q);
        	  if (L != null && R != null) return root;  // if p and q are on both sides
        	  return L!=null ? L : R;  // either one of p,q is on one side OR p,q is not in L&R subtrees
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
    	    System.out.println("q is child of p  :   "+commonAncestorBad(tree, tree.left.left, tree.left.left.left).val);
    	    
    	    // Case 3 :  p = 4, q = 20 (q is not in the tree)
    	    System.out.println("q is not in the tree  :  "+commonAncestorBad(tree, tree.left.left, new TreeNode(20)).val);
    	    
    	    
    		//System.out.println(LCA(tree, new TreeNode(6), new TreeNode(15)).val);
        }

}
