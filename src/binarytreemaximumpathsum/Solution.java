package binarytreemaximumpathsum;

import treenode.TreeNode;

public class Solution {
	public int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	if(root==null)
    		return 0;
    	path(root);
    	return maxsum;
    }
    public int path(TreeNode root){
        if(root==null)
        	return 0;
        if(root.left==null&&root.right==null){
        	if(root.val>maxsum)
        		maxsum = root.val;
        	return root.val;
        }
        int lval = path(root.left);
        int rval = path(root.right);
        int maxval = lval;
        int minval = rval;
        if(lval<rval){
        	maxval = rval;
        	minval = lval;
        }
        if(maxval<=0)
        	maxval = 0;
        int respath = maxval+root.val;
        if(minval<=0)
        	minval = 0;
        int sumpath = respath+minval;
        if(sumpath>maxsum)
        	maxsum = sumpath;
        return respath;
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(-2);
		TreeNode n2 = new TreeNode(-1);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(-11);
		TreeNode n5 = new TreeNode(-13);
		TreeNode n6 = new TreeNode(-4);
		TreeNode n7 = new TreeNode(-7);
		TreeNode n8 = new TreeNode(-7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.right = n7;
		n7.right = n8;
		Solution s = new Solution();
		System.out.println(s.maxPathSum(n1));
	}
}
