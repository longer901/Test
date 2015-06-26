package foursum;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public List<List<Integer>> fourSum1(int[] candidates, int target) {
		
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
		if(k<candidateList.size()&&oneRes.size()<3&&sum<=target){
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
		}else{
			if(sum==target&&oneRes.size()==3){
				List<Integer> tem = new ArrayList<Integer>();
				tem.addAll(oneRes);
				res.add(tem);
				System.out.println(oneRes);
			}
		}	
	}
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		//第一个数字 a1+a2+a3+a4 =target  =>  a2+a3+a4 =target - a1 
		for(int k = 0 ;k<nums.length;k++){//a1
			int threeSum = target - nums[k];//target - a1 
			if(k>0&&nums[k-1]==nums[k]){
				continue;
			}
			for(int t=k+1;t<nums.length-2;t++){//a2
				if(t>k+1&&nums[t-1]==nums[t]){
					continue;
				}
				int i = t+1;//a3
				int j = nums.length-1;//a4
				while(i<j){
					int sum = nums[t]+nums[i]+nums[j];
					if(sum<threeSum){
						i++;
					}else if(sum>threeSum){
						j--;
					}else{
						List<Integer> one = new ArrayList<Integer>();
						one.add(nums[k]);
						one.add(nums[t]);
						one.add(nums[i]);
						one.add(nums[j]);
						res.add(one);
						i++;
						j--;
						while(j>0&&nums[j]==nums[j+1]){
							j--;
						}
						while(i<nums.length-1&&nums[i]==nums[i-1]){
							i++;
						}
					}
				}
			}
		}
		return res;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		//int[] k = {-499,-486,-479,-462,-456,-430,-415,-413,-399,-381,-353,-349,-342,-337,-336,-331,-330,-322,-315,-280,-271,-265,-249,-231,-226,-219,-216,-208,-206,-204,-188,-159,-144,-139,-123,-115,-99,-89,-80,-74,-61,-22,-22,-8,-5,4,43,65,82,86,95,101,103,123,149,152,162,165,168,183,204,209,209,220,235,243,243,244,248,253,260,273,281,284,288,290,346,378,382,384,407,411,423,432,433,445,470,476,497};
		int[] k = {0,0,0,0,0,0};
		long startMili = System.currentTimeMillis();
		List<List<Integer>> res = s.fourSum(k,0);
		long endMili = System.currentTimeMillis();
		System.out.println("【 time： "+(endMili-startMili)+" 毫秒 】");
		System.out.println(res);
	}
}
