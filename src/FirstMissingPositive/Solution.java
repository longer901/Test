package FirstMissingPositive;

import java.util.HashSet;

public class Solution {
	//时间O(n) 空间O(n)  空间复制度高
    public int firstMissingPositive(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 1;
        HashSet<Integer> set = new HashSet<Integer>(); 
        int maxnum = Integer.MIN_VALUE;
        for(int n : nums){
        	if(n>maxnum)
        		maxnum = n;
        	set.add(n);
        }
    	for(int i=2;i<=maxnum;i++){
    		if(!set.contains(i-1)){
    			return i-1;
    		}
    	}
    	return maxnum+1;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//[1000,-1]
		//[1]
		//[2]
		int[] nums = new int[]{3};
		System.out.println(s.firstMissingPositive(nums));
	}

}
