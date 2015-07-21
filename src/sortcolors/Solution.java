package sortcolors;

public class Solution {

    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1)
        	return;
        int begin = 0;
        int end = nums.length-1;
        while(begin<=end){
        	while(begin<=end&&(nums[end]==2||nums[begin]==0)){
        		if(nums[end]==2)
        			end--;
        		if(nums[begin]==0)
        			begin++;
        	}
        	if(begin>end)
        		return;
        	if(nums[begin]==2||nums[end]==0){
        		int t = nums[begin];
        		nums[begin] = nums[end];
        		nums[end] = t;
        		if(nums[begin]==2)
        			begin++;
        		if(nums[end]==0)
        			end--;
        	}else{
        		int i = begin;
        		for(;i<=end;i++){
        			if(nums[i]!=1){
        				if(nums[i]==0){
        	        		int t = nums[i];
        	        		nums[i] = nums[begin];
        	        		nums[begin] = t;
        	        		begin++;
        				}else if(nums[i]==2){
        	        		int t = nums[i];
        	        		nums[i] = nums[end];
        	        		nums[end] = t;
        	        		end--;
        				}
        				break;
        			}
        		}
        		if(i==end+1)
        			return;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {1,1,1,2,1,1,1,1,0,1,1};
		s.sortColors(nums);
		System.out.println();
	}

}
