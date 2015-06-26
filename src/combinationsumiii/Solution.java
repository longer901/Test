package combinationsumiii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

        
    public int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
	public int sum = 0;
	public int target;
	public int num = 0;
	public List<Integer> oneRes = new ArrayList<Integer>();
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum3(int k, int tar) {
        target = tar;
        num = k;
        backTrack(0);
		return res;
    }	
	public void backTrack(int k){
		if(k>=num||sum>=target){
			if(k==num&&sum==target){
				List<Integer> tem = new ArrayList<Integer>();
				tem.addAll(oneRes);
				res.add(tem);
			}
		}else if(sum<target){
			int i=(k==0)?0:oneRes.get(oneRes.size()-1);
			for(;i<candidates.length;i++){
				oneRes.add(candidates[i]);
				sum += candidates[i];
				backTrack(k+1);
				sum -= candidates[i];
				oneRes.remove(oneRes.size()-1);
			}
		}	
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int t1 = 3;
		int t2 = 0;
		List<List<Integer>> res = s.combinationSum3(t1,t2);
		System.out.println(res);
	}
}
