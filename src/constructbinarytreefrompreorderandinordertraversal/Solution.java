package constructbinarytreefrompreorderandinordertraversal;

import treenode.TreeNode;

public class Solution {
	public int[] preorder ;
	public int[] inorder ;
    public TreeNode buildTree(int[] pre, int[] in) {
    	preorder = pre;
    	inorder = in;
        return build(0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int prebegin,int preend,int inbegin,int inend){
    	if(prebegin>preend)
    		return null;
    	if(prebegin==preend)
    		return new TreeNode(preorder[prebegin]);
    	TreeNode head = new TreeNode(preorder[prebegin]);
    	int index = -1;
    	for(int i=inbegin;i<=inend;i++){
    		if(inorder[i]==preorder[prebegin]){
    			index = i;break;
    		}
    	}
    	head.left = build(prebegin+1,prebegin+(index-inbegin),inbegin,index-1);
    	head.right = build(prebegin+(index-inbegin)+1,preend,index+1,inend);
    	return head;
    }
	public static void main(String[] args) {
		int[] pre = {1};
		int[] in = {1};
		Solution s = new Solution();
		TreeNode t = s.buildTree(pre,in);
		System.out.println(t);
	}
}
