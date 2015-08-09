package searchforarange;

public class Solution {
	
	public int[] res = new int[]{-1,-1};
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
        	return res;
    	binarySearch(nums,0,nums.length-1,target);
        return res;
    }
    public void binarySearch(int[] nums,int i,int j,int target){
    	if(i>j)
    		return;
    	int mid = (i + j)/2;
    	if(nums[mid]==target){
    		int start = mid;
    		while(start-1>=0){
    			if(nums[start-1]!=target)
    				break;
    			start--;
    		}
    		int end = mid;
    		while(end+1<nums.length){
    			if(nums[end+1]!=target)
    				break;
    			end++;
    		}
        	res = new int[]{start,end};
    	}else if(nums[mid]>target){
    		binarySearch(nums,i,mid-1,target);
    	}else{
    		binarySearch(nums,mid+1,j,target);
    	}
    }    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = new int[]{1,1,3,3,4,4,4,4,4,5,5,5};
		int target = 1;
		int[] res = s.searchRange(nums, target);
		System.out.println(res[0]+"|---|"+res[1]);
	}

}
