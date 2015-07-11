package validatebinarysearchtree;

import treenode.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return traceTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE,false,false);
    }
    public boolean traceTree(TreeNode node,int min,int max,boolean left,boolean right){
    	if(node==null)
    		return true;
    	boolean flag = true;
    	if(right)
    		flag &=node.val<max;
    	if(left)
    		flag &=node.val>min;
    	if(!flag)
    		return false;
	    return traceTree(node.left,min,node.val,left,true)&&traceTree(node.right,node.val,max,true,right);
    }
	public static void main(String[] args) {
		
	}
}
