package countcompletetreenodes;

import treenode.TreeNode;

public class Solution {
	
	//time out 
//	public int pow;
//	public int max;
//	public int height = -1;
//	public int h =-1;
//	public boolean flag = true;
//    public int countNodes(TreeNode root) {
//    	TreeNode t = root;
//    	while(t!=null){
//    		height++;
//    		pow=1<<pow;
//    		max += pow; 
//    		t = t.left;
//    	}
//    	postTrace(root);
//    	return max;
//    }
//    private void postTrace(TreeNode node) {
//		if(node==null||h+1==height||!flag)
//			return;
//		h++;
//	    postTrace(node.right);
//	    postTrace(node.left);
//	    if(h+1==height){
//	    	int tem = max;
//	    	if(node.right==null)
//	    		max--;
//	    	if(node.left==null)
//	    		max--;
//	    	flag = (tem-2)==max;
//	    }
//    	h--;
//	}
	
	public int sum = 0;
	public int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		int lenleft = length(root.left);
		int lenright = length(root.right);
		if(lenleft==lenright){
			sum += (1<<(lenleft+1))-1+countNodes(root.right); 
		}else{
			sum += (1<<(lenright+1))-1+countNodes(root.left); 
		}
		return sum+1;
	}
	public int length(TreeNode node){
		int len = -1;
		while(node!=null){
			node = node.left;
			len++;
		}
		return len;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		Solution s = new Solution();
		System.out.println(s.countNodes(n1));
//		System.out.println((1<<2)-1);
	}
}
