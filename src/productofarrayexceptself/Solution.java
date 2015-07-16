package productofarrayexceptself;


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        pre[0]=1;
    	for(int i=1;i<nums.length;i++)
    		pre[i] =nums[i-1]*pre[i-1];
        int[] aft = new int[nums.length];
        aft[nums.length-1] = 1;
    	for(int j=nums.length-2;j>=0;j--)
    		aft[j] =nums[j+1]*aft[j+1];
    	for(int k = 0 ;k<nums.length;k++){
    		res[k] = pre[k]*aft[k];
    	}
    	return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1,2,3,4};
		System.out.println(s.productExceptSelf(nums));
	}
}
