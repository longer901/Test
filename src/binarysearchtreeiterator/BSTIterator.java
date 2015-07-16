package binarysearchtreeiterator;

import java.util.Stack;

import treenode.TreeNode;

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    private void inorder(TreeNode node){
    	while(node!=null){
    		stack.add(node);
    		node = node.left;
    	}
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()>0;
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
    	if(node.right!=null)
    		inorder(node.right);
        return node.val;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(12);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(14);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(13);
		TreeNode n7 = new TreeNode(15);
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n3.left = n6;
//		n3.right = n7;
		BSTIterator s = new BSTIterator(null);
		while(s.hasNext()){
			System.out.println(s.next());
		}
	}


	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}
