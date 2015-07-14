package binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class Solution {
	public List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	inorder(root);
        return res;
    }
    public void inorder(TreeNode node){
    	if(node==null)
    		return;
    	 inorder(node.left);
    	 res.add(node.val);
    	 inorder(node.right);
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
		System.out.println(s.inorderTraversal(n1));
	}
}
