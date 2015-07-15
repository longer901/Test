package kthsmallestelementinabst;

import treenode.TreeNode;

public class Solution {
	public int res;
	public int tk=0;
    public int kthSmallest(TreeNode root, int k) {
    	inorder(root,k);
    	return res;
    }
    public void inorder(TreeNode node,int k){
    	if(node==null)
    		return;
    	inorder(node.left,k);
    	tk++;
    	if(tk==k){
    		res = node.val;
    		return;
    	}
    	inorder(node.right,k);
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		Solution s = new Solution();
		System.out.println(s.kthSmallest(n1,4));
	}
}
