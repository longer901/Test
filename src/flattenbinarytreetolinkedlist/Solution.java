package flattenbinarytreetolinkedlist;

import treenode.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
    	changeNode(root);
    }
    public TreeNode changeNode(TreeNode node){
    	if(node==null)
    		return null;
    	if(node.left==null&&node.right==null)
    		return node;
    	TreeNode left = changeNode(node.left);
    	changeNode(node.right);
    	if(left!=null){
	    	left.right = node.right;
	    	node.right = node.left;
	    	node.left = null;
    	}
    	TreeNode tem = node;
    	while(tem.right!=null){
    		tem = tem.right;
    	}
    	return tem;
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;
		Solution s = new Solution();
		s.flatten(n1);
		System.out.println();
	}
}
