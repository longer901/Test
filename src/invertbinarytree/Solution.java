package invertbinarytree;

import treenode.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	recerse(root);
    	return root;
    } 
    public void recerse(TreeNode root){
        if(root==null)
        	return ;
        TreeNode r = root.right;
        TreeNode l = root.left;
        root.right = l;
        root.left = r;
        recerse(root.left);
        recerse(root.right);
    }
	public static void main(String[] args) {
//		TreeNode n1 = new TreeNode(5);
//		TreeNode n2 = new TreeNode(4);
//		TreeNode n3 = new TreeNode(8);
//		TreeNode n4 = new TreeNode(11);
//		TreeNode n5 = new TreeNode(13);
//		TreeNode n6 = new TreeNode(4);
//		TreeNode n7 = new TreeNode(7);
//		TreeNode n8 = new TreeNode(2);
//		TreeNode n9 = new TreeNode(5);
//		TreeNode n10 = new TreeNode(1);
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = null;
//		n3.left = n5;
//		n3.right = n6;
//		n4.left = n7;
//		n4.right = n8;
//		n5.left = n5.right = null;
//		n6.left = n9;
//		n6.right = n10;
		
		TreeNode n1 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(-3);
		n1.left = null;
		n1.right = n3;
		Solution s = new Solution();
		System.out.println(s.invertTree(n1));
	}
}
