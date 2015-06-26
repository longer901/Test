package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//logn*n2
//fail:[7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6]
public class Solution {
	//fail time limit
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
	    Arrays.sort(nums);
	    Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
	    for(int k : nums){
		    System.out.print(k+" ");
	    	int a = 0;
	    	if(numMap.containsKey(k))
	    		a = numMap.get(k);
	    	numMap.put(k, a+1);	
	    }
	    for(int k : numMap.keySet()){
	    	System.out.print(k+" ");
	    }
	    
	    System.out.println();
	    if(numMap.containsKey(0)&&numMap.get(0)==3){
			List<Integer> one = new ArrayList<Integer>();
			one.add(0);
			one.add(0);
			one.add(0);
			res.add(one);
			numMap.put(0, 1);
	    }
		for(int i=0;i<nums.length-2;i++){
			for(int j=i+1;j<nums.length;j++){
				int v = nums[i]+nums[j];
				int n = numMap.containsKey(0-v)?numMap.get(0-v):0;
				if(v<0&&-v>nums[j]&&n>0){
					List<Integer> one = new ArrayList<Integer>();
					one.add(nums[i]);
					one.add(nums[j]);
					one.add(-v);
					res.add(one);
					numMap.put(0-v, n-1);
				}
			}
		}
		return res;
	}
	
	
//fail		Input:	[-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
//			Output:	[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[0,0,0]]
//			Expected:	[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int t=0;t<nums.length-2;t++){
			if(t>0&&nums[t-1]==nums[t]){
				continue;
			}
			int i = t+1;
			int j = nums.length-1;
			while(i<j){
				int mark = nums[i]+nums[j];
				if(mark+nums[t]<0){
					i++;
				}else if(mark+nums[t]>0){
					j--;
				}else{
					List<Integer> one = new ArrayList<Integer>();
					one.add(nums[t]);
					one.add(nums[i]);
					one.add(nums[j]);
					res.add(one);
					if(nums[t]==0)
						break;
					i++;
					j--;
					while(j>0&&nums[j]==nums[j+1]&&nums[j]!=0){
						j--;
					}
					while(i<nums.length-1&&nums[i]==nums[i-1]&&nums[i]!=0){
						i++;
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};	
		List<List<Integer>> res= s.threeSum(nums); 
		for(List<Integer> os : res){
			System.out.println(os);
		}
	}
}
