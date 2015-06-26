package maximumsubarray;

public class solution {
	//DP
	/*dp(i):从nums[0]到nums[i]开始的最大sum值
	 * If dp[i-1] < 0, dp[i] = nums[i]
	 * if dp[i-1] >0, dp[i] = nums[i] + dp[i-1]
	 */
    public int maxSubArray(int[] nums) {
    	int max = Integer.MIN_VALUE;
    	int presum = 0;//dp(i-1)
    	int cursum = 0;//dp(i)
    	for(int i=0;i<nums.length;i++){
    		if(presum<=0){
    			cursum = nums[i];
    		}else{
    			cursum = presum+nums[i];
    		}
    		max = max<cursum?cursum:max;
    		presum = cursum;//O(n)--->O(1)
    	}
        return max;
    }
	public static void main(String[] args) {
		int[] par = new int[]{-2,-1,-3,4,-1,2,1,-5,4};
		solution s = new solution();
		System.out.println(s.maxSubArray(par));
	}
}
