package searchinrotatedsortedarrayii;


	public class Solution {

	    public boolean search(int[] nums, int target) {
	        if(nums==null||nums.length==0){
	        	return false;
	        }
	        int i=0;
	        int j=nums.length-1;
	        while(i<=j){
	        	if(i!=j&&nums[i]==nums[j]){
	        		j--;
	        		continue;
	        	}
	        	int mid = (i+j)/2;
	        	if(nums[mid]==target)
	        		return true;
	        	if(nums[mid]<=nums[j]){
	        		if(nums[mid]<target&&target<=nums[j]){
	        			i=mid+1;
	        		}else{
	        			j=mid-1;
	        		}
	        	}else if(nums[mid]>=nums[i]){
	        		if(nums[mid]>target&&target>=nums[i]){
	        			j=mid-1;
	        		}else{
	        			i=mid+1;
	        		}
	        	}
	        }
	        return false;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = new int[]{1,2,2,2,3,3,4,1};
		System.out.println(s.search(nums,6));
	}

}
