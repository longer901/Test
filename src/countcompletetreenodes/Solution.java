package countcompletetreenodes;

import treenode.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
    	if(root==null)
    		return 0;
    	int nl = countNodes(root.left);
    	int nr = countNodes(root.right);
    	return nl+nr+1;
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
//		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
//		n4.right = n7;
		Solution s = new Solution();
		System.out.println(s.countNodes(n1));
	}
}
