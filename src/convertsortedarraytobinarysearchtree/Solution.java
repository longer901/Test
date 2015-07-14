package convertsortedarraytobinarysearchtree;

import treenode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }
    public TreeNode makeTree(int[] nums,int b,int e){
    	if(b>e)
    		return null;
    	if(b==e){
    		return new TreeNode(nums[b]);
    	}
    	int inner = (b+e)/2;
    	TreeNode tem = new TreeNode(nums[inner]);
    	tem.left = (inner-1+b)/2==inner?null:makeTree(nums,b,inner-1);
    	tem.right = (inner+1+e)/2==inner?null:makeTree(nums,inner+1,e);
    	return tem;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1,2,3,4};
		TreeNode show = s.sortedArrayToBST(nums);
		System.out.println(show.val);
	}
}
