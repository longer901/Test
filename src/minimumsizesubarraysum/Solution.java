package minimumsizesubarraysum;

public class Solution {


    public int minSubArrayLen(int s, int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
    	int min = Integer.MAX_VALUE;
    	int sum = 0;
    	int begin = 0;
    	int end = 0;
    	while(begin<=end&&end<nums.length){
    		while(begin<=end&&end<nums.length){
    			sum += nums[end];
    			if(sum>=s){
    	    		min = Math.min(end-begin+1,min);
    	    		if(min==1)
    	    			return 1;
    				break;
    			}
    			end++;
    		}
    		while(begin<=end){
    			sum -= nums[begin];
				begin++;
    			if(sum<s)
    				break;
        		min = Math.min(end-begin+1,min);
        		if(min==1)
        			return 1;
    		}
    		end++;
    	}
    	if(min == Integer.MAX_VALUE)
    		min = 0;
    	return min;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {3,4,1,2,3,4,1,4,3};
		System.out.println(s.minSubArrayLen(36, nums));
	}
//    //stack overflow
//    public void backtrack(int[] nums,int b,int e){
//    	if(b>e)
//    		return;
//    	if(sum<target)
//    		return;
//    	if(sum>=target){
//    		min = Math.min(e-b+1, min);
//    	}
//    	if(nums[b]>nums[e]){
//    		int m = nums[e];
//    		sum -= m;
//    		backtrack(nums,b,e-1);
//    		sum += m;
//    	}else if(nums[b]<nums[e]){
//    		int m = nums[b];
//    		sum -= m;
//    		backtrack(nums,b+1,e);
//    		sum += m;
//    	}else{
//    		int m1 = nums[e];
//    		sum -= m1;
//    		backtrack(nums,b,e-1);
//    		sum += m1;
//    		int m2 = nums[b];
//    		sum -= m2;
//    		backtrack(nums,b+1,e);
//    		sum += m2;
//    	}
//    }


}
