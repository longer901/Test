package searchinrotatedsortedarray;

public class Solution {

    public int search(int[] nums, int target) {
        int res = -1;
        if(nums==null||nums.length==0){
        	return res;
        }
        int i=0;
        int j=nums.length-1;
        while(i<=j){
        	int mid = (i+j)/2;
        	if(nums[mid]==target)
        		return mid;
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
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = new int[]{3};
		int target = 3;
		System.out.println(s.search(nums, target));
	}

}
