package houserobberii;

import java.util.Arrays;


public class Solution {
    public int rob(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];
    	if(nums.length==2)
    		return Math.max(nums[0],nums[1]);
    	if(nums.length==3)
    		return Math.max(Math.max(nums[0],nums[2]), nums[1]);
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        nums1[2] = nums1[2] + nums1[0];
        nums2[3] = nums2[3] + nums2[1];
    	for(int i=3;i<nums.length-1;i++){
    		nums1[i] +=(nums1[i-2]<nums1[i-3])?nums1[i-3]:nums1[i-2];
    		nums2[i+1] +=(nums2[i-1]<nums2[i-2])?nums2[i-2]:nums2[i-1];
    	}
    	return Math.max(Math.max(nums1[nums.length-2], nums1[nums.length-3]),Math.max(nums2[nums.length-1], nums2[nums.length-2]));	
    }
	public static void main(String[] args) {
		int[] par = new int[] { 5,1,1,2,3,19};
		Solution s = new Solution();
		System.out.println(s.rob(par));
	}
}
