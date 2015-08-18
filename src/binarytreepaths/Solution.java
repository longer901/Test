package binarytreepaths;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class Solution {
	public List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
    	if(root==null)
    		return res;
    	preorder(root,"");
    	return res;
    }
    public void preorder(TreeNode root,String s){
    	if(root.left==null&&root.right==null){
    		s +="->" + root.val;
    		res.add(s.substring(2));
    		return;
    	}
    	s += "->" + root.val;
    	if(root.left!=null)
    		preorder(root.left,s);
    	if(root.right!=null)
    		preorder(root.right,s);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		Solution s = new Solution();
		System.out.println(s.binaryTreePaths(n1));
	}

}
