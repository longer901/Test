package balancedbinarytree;

import treenode.TreeNode;

public class Solution {
	
    public boolean isBalanced(TreeNode root) {
	      if(root==null)
	    	  return true;
	      return traceTree(root)!=-1;
    }
    public int traceTree(TreeNode node){
    	if(node==null){
    		return 0;
    	}else{
    		int right = traceTree(node.right);
    		int left  = traceTree(node.left);
    		return right==-1||left==-1||Math.abs(right-left)>1?-1:Math.max(right,left)+1;
    	}
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.right = n7;
		Solution s = new Solution();
		System.out.println(s.isBalanced(n1));
	}
}
