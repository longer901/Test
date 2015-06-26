package containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
    	
    	if(nums.length==0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=1;i<=nums.length;i++){
        	set.add(nums[i-1]);
        	if(set.size()!=i)
        		return true;
        }
        return false;
    }
    public static void main(String[] args) {
    	int[] nums = new int[]{3,3};
    	System.out.println(containsDuplicate(nums));
	}
}
