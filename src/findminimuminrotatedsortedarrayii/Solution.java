package findminimuminrotatedsortedarrayii;


public class Solution {
    public int findMin(int[] nums) {
    	int res = 0;
        int i = 0;
        int j=nums.length-1;
        while(i<j){
        	if(i+1==j){
        		res = nums[i]<nums[j]?i:j;
        		break;
        	}
        	while(i<j&&nums[j]==nums[i])
        		j--;
        	int mid = (i+j)/2;
        	if(nums[mid]<=nums[j])
        		j = mid;
        	else
        		i = mid;
        }
        return nums[res];
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[]{3,3,3,3,3,3};
		System.out.println(s.findMin(nums));
	}
}
