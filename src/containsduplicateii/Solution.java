package containsduplicateii;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums.length==0||k==0) return false;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	int t = nums[i];
        	if(map.containsKey(t)){
        		int l = map.get(t);
        		int abs = Math.abs(l-i);
        		if(abs<=k)
        			return true;
        		else
        			map.put(t, i);
        	}else
        		map.put(t, i);
        }
        return false; 
    }
    public static void main(String[] args) {
    	int[] nums = new int[]{1,2,1};
    	System.out.println(containsNearbyDuplicate(nums,1));
	}
}
