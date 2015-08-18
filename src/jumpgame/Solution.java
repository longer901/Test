package jumpgame;

import java.util.ArrayList;

public class Solution {
    public boolean canJump(int[] nums) {
    	if(nums==null||nums.length==0)
    		return false;
    	if(nums.length==1)
    		return true;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(nums.length-1);
    	for(int i=nums.length-2;i>=0;i--){
			if(nums[0]>=list.get(0))
				return true;
    		if(nums[i]+i>=list.get(0)){
    			list.add(0,i);
    		}
    	}
    	System.out.println(list);
        return nums[0]>=list.get(0);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		//1,2
		//2,3,1,1,4
		//3,2,1,0,4
		//1,2,3
		int[] nums = new int[]{1,1,1,0};
		System.out.println(s.canJump(nums));
	}
}
