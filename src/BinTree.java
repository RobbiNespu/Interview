import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;
public class BinTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*    Unbalanced Tree
		 *               10
		 *           8       13
		 *        5    
		 *      1   6
		 */
		TreeNode unbalancedTree = new TreeNode(10);
		unbalancedTree.left = new TreeNode(8);
		unbalancedTree.left.left= new TreeNode(5);
		unbalancedTree.left.left.left = new TreeNode(1);
		unbalancedTree.left.left.right = new TreeNode(6);
		unbalancedTree.right = new TreeNode(13);
		isBalancedPoor(unbalancedTree);
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.left.left= new TreeNode(3);
		 /*
				1
		      2
		    3   
		*/
		TreeNode tree2 = new TreeNode(1);
		tree2.right = new TreeNode(2);
		tree2.right.right = new TreeNode(3);
		/*
		 *             1
		 *                2
		 *                   3
		 */
		
		TreeNode tree3 = new TreeNode(1);
		tree3.left = new TreeNode(2);
		tree3.left.left= new TreeNode(3);
		 /*
				1
      	   	  2
            3   
		 */
		
		/*
		 *   Mirror tree
		 *                1
		 *             2     5
		 *          4           6
		 */
		TreeNode mirrorTree = new TreeNode(1);
		mirrorTree.left = new TreeNode(2);
		mirrorTree.left.left= new TreeNode(4);
		mirrorTree.right = new TreeNode(5);
		mirrorTree.right.right = new TreeNode(6);
		
		//System.out.println(isSameTree2(tree3, tree));
		
		//System.out.println(isMirrorTree(mirrorTree.left, mirrorTree.right));
		pre(mirrorTree);
		System.out.println("after mirroring...");
		mirrorTree(mirrorTree);
		pre(mirrorTree);
		

	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q){
	     if(p==null&&q!=null || p!=null&&q==null) return false;
	     if(p==null&&q==null) return true; 
	     if(p.val!=q.val) return false;
	     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
	}
	
    public static boolean isSameTree2(TreeNode p, TreeNode q){
        if(p==null && q==null) 
            return true;
        if(p== null && q != null)
            return false;
        if(p!= null && q == null)
            return false;
        
        //both child are not null      
        boolean l = isSameTree(p.left, q.left);
        if(l==false) return false; //optimize
        if(p.val != q.val)
           return false;
        boolean r = isSameTree(p.right, q.right);                         
        return l&&r; 
    }
    
    public static boolean isMirrorTree(TreeNode p, TreeNode q){
        if(p==null&&q!=null || p!=null&&q==null) return false;
        if(p==null&&q==null) return true;
        if(p.val != q.val) return false;
        return isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }
    
    
    public static void mirrorTree(TreeNode btree) {
    	 if(btree == null) {
    	   return;
    	 }
    	 mirrorTree(btree.left);
    	 mirrorTree(btree.right);
    	 TreeNode tmp = btree.left;
    	 btree.left = btree.right;
    	 btree.right = tmp; 
    }
    
    public static void pre(TreeNode r){
        if(r!= null){
            System.out.print(r.val+",");
            pre(r.left);
            pre(r.right);  
        }                         
    }
    
    public static void in(TreeNode r){
        if(r!= null){
            in(r.left);
            System.out.print(r.val+",");
            in(r.right);  
        }                         
    }
    
    public static void post(TreeNode r){
        if(r!= null){
            post(r.left);
            post(r.right);  
            System.out.print(r.val+",");
        }                         
    }
    
    public static int checkHeight(TreeNode root){
    	if(root == null)
    		return 0;
    	// check if left is balanced
    	// if the subtree is balanced, then checkHeight will return the actual
    	// height of the subtree.
    	// if the subtree is not balanced, then checkHeight will return -1.
    	// We will immediately break and return -1 from the current call
    	int leftHeight = checkHeight(root.left);
    	if(leftHeight == -1)
    		return -1;
    	
    	int rightHeight = checkHeight(root.right);
    	if(rightHeight == -1)
    		return -1;
    	
    	int heightDiff = leftHeight-rightHeight;
    	if(Math.abs(heightDiff) > 1)
    		return -1;
    	else
            return Math.max(leftHeight, rightHeight)+1;
    }
    
    // like a wrapper to call recursive function (checkHeight)
    public static boolean isBalanced(TreeNode root){
    	if(checkHeight(root) == -1)
    		return false;
    	else
    		return true;			
    }
    
    public static int getHeight(TreeNode root){
    	if(root == null)
    		return 0;
    	return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
    
    public static boolean isBalancedPoor(TreeNode root){
    	if(root==null) return true;
    	
    	int heightDiff = getHeight(root.left) - getHeight(root.right);
    	if(Math.abs(heightDiff) > 1 )
    		return false;
    	else
    		return isBalancedPoor(root.left) && isBalanced(root.right);
    }
    
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
    	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    	if(root != null)
    		current.add(root);
    	
    	while(current.size()>0){
    		result.add(current);
    		LinkedList<TreeNode> parents = current;
    		//clear current ArrayList for adding next level.
    		current = new LinkedList<TreeNode>();
    		for(TreeNode parent : parents){
    			if(parent.left != null)
    				current.add(parent.left);
    			if(parent.right != null)
    				current.add(parent.right);
    		}
    	}
    	return result;
    }
    
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
