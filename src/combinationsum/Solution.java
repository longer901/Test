package combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public int[] candidates;
	public int sum = 0;
	public int target;
	public List<Integer> oneRes = new ArrayList<Integer>();
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		this.candidates = candidates;
        this.target = target;
        backTrack();
		return res;
    }
	
	public void backTrack(){
		if(sum==target){
			List<Integer> tem = new ArrayList<Integer>();
			tem.addAll(oneRes);
			res.add(tem);
		}else if(sum<target){
			for(int i=0;i<candidates.length;i++){
				if(oneRes.size()>0&&candidates[i]<oneRes.get(oneRes.size()-1)){
					continue;
				}
				oneRes.add(candidates[i]);
				sum += candidates[i];
				backTrack();
				sum -= candidates[i];
				oneRes.remove(oneRes.size()-1);
			}
		}	
	}
}