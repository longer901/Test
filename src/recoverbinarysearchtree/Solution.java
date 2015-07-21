package recoverbinarysearchtree;


import treenode.TreeNode;

public class Solution {
	public TreeNode pre = null;
	public TreeNode cur = null;
	public TreeNode preone = null;
	public TreeNode one = null;
	public TreeNode pretwo = null;
	public TreeNode two = null;
	public void recoverTree(TreeNode root) {
		inorder(root);
		if(two!=null){
	    	int tem = preone.val;
	    	preone.val = two.val;
	    	two.val = tem;
		}else if(one!=null){
	    	int tem = one.val;
	    	one.val = preone.val;
	    	preone.val = tem;
		}
    }
    public void inorder(TreeNode node){
    	if(node==null)
    		return;
    	inorder(node.left);
    	pre = cur;
    	cur = node;
    	if(pre!=null&&cur!=null&&cur.val<pre.val){
    		if(one==null){
    			preone = pre;
    			one = cur;
    		}else if(two==null){
    			pretwo = pre;
    			two = cur;
    		}
    	}
    	inorder(node.right);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(11);
		TreeNode n7 = new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.right = n7;
		s.recoverTree(n1);
		System.out.println(s.one.val);
		System.out.println(s.two.val);
		//TreeNode n = n1;
	}
}
