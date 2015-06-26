package twosum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
    	Map<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]+nums[i]==target){
    			if(sortedMap.containsKey(nums[i])){
    				res[0] = sortedMap.get(nums[i]);
    				res[1] = i;
    				return res;
    			}
    		}
    		sortedMap.put(nums[i],i);
    	}
    	List<Integer> keySorted = new ArrayList<Integer>(sortedMap.keySet());
    	int i=0;
    	int j=keySorted.size()-1;
    	while(i<j){
    		int a = keySorted.get(i);
    		int b = keySorted.get(j);
    		int t = a + b;
    		if(t>target){
    			j--;
    		}else if(t<target){
    			i++;
    		}else{
    			res[0]=sortedMap.get(a)+1;
    			res[1]=sortedMap.get(b)+1;
    			break;
    		}
    	}
    	if(res[0]>res[1]){
    		int t = res[0];
    		res[0] = res[1];
    		res[1] = t;
    	}
        return res;
    }
    public static void main(String[] args){
    	int[] numbers={-1,-2,-3,-4,-5};
    	int target=-8;
    	int[] res = twoSum(numbers,target);
    	System.out.println(res[0]+"-"+res[1]);
    }
}