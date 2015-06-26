package Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<Integer> oneRes = new LinkedList<Integer>();
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public int[] nums;
    public List<List<Integer>> permute(int[] num) {
    	nums = num;
    	oneRes.add(nums[0]);
        backTrack(1);
    	return res;
    }
    public void backTrack(int k){
    	if(k>=nums.length){

    	}else{
    		for(int i=k;i>=0;i--){
    			oneRes.add(i,nums[k]);
        		if(k==nums.length-1){
    				List<Integer> tem = new ArrayList<Integer>();
    				tem.addAll(oneRes);
    				res.add(tem);
        		}
    			backTrack(k+1);
    			oneRes.remove(i);
    		}
    	}
    }
	public static void main(String[] args) {
			Solution s = new Solution();
			int[] nums = new int[]{1,2,3};
			System.out.println(s.permute(nums));
	}
}
