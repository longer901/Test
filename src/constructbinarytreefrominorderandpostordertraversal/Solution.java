package constructbinarytreefrominorderandpostordertraversal;

import treenode.TreeNode;

public class Solution {
	public int[] postorder ;
	public int[] inorder ;
    public TreeNode buildTree(int[] in, int[] post) {
    	postorder = post;
    	inorder = in;
        return build(0,postorder.length-1,0,inorder.length-1);
    }
	private TreeNode build(int postbegin,int postend,int inbegin,int inend) {
    	if(postbegin>postend)
    		return null;
    	if(postbegin==postend)
    		return new TreeNode(postorder[postend]);
    	TreeNode head = new TreeNode(postorder[postend]);
    	int index = -1;
    	for(int i=inbegin;i<=inend;i++){
    		if(inorder[i]==postorder[postend]){
    			index = i;break;
    		}
    	}
    	head.left = build(postbegin,postbegin+(index-inbegin)-1,inbegin,index-1);
    	head.right = build(postbegin+(index-inbegin),postend-1,index+1,inend);
    	return head;
	}
	public static void main(String[] args) {
		int[] pre = {};
		int[] in = {};
		Solution s = new Solution();
		TreeNode t = s.buildTree(pre,in);
		System.out.println(t);
	}
}
