package combinationSum2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
	
	public List<Integer> candidateList = null;
	public Map<Integer,Integer> num_map = null;
	public int sum = 0;
	public int target;
	public List<Integer> oneRes = new ArrayList<Integer>();
	public List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		num_map = new TreeMap<Integer,Integer>();
		for(int i : candidates){
			if(num_map.containsKey(i)){
				num_map.put(i, num_map.get(i)+1);
			}else{
				num_map.put(i,1);
			}
		}
        this.target = target;
		candidateList = new ArrayList<Integer>(num_map.keySet());
        backTrack(0);
		return res;
    }
	
	public void backTrack(int k){
		if(k>=candidateList.size()||sum>=target){
			if(sum==target){
				List<Integer> tem = new ArrayList<Integer>();
				tem.addAll(oneRes);
				res.add(tem);
			}
		}else{
			int n = num_map.get(candidateList.get(k));
			for(int i=0;i<=n;i++){
				int m = i;
				if(i>0){
					while(--m>=0){
						oneRes.add(candidateList.get(k));
					}
					sum += candidateList.get(k)*i;
				}
				backTrack(k+1);
				if(i>0){
					sum -= candidateList.get(k)*i;
					while(++m<i){
						oneRes.remove(oneRes.size()-1);
					}	
				}
			}
		}	
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] k = {10,1,2,7,6,1,5};
		System.out.println(s.combinationSum2(k,8));
	}
	
}
