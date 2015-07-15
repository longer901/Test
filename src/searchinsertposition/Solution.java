package searchinsertposition;

public class Solution {
	public int target ;
    public int searchInsert(int[] nums, int t) {
    	if(nums.length==0)
    		return 0;
        target = t;
        return binarySearch(nums,0,nums.length-1);
    }
    private int binarySearch(int[] nums, int i, int j) {
    	if(j==i){
    		return target>nums[i]?i+1:i;
    	}
    	int mid = (i+j)/2;
    	if(nums[mid]==target)
    		return mid;
    	if(target<nums[mid])
    		return binarySearch(nums,i,j-1);
    	if(target>nums[mid])
    		return binarySearch(nums,i+1,j);
		return 0;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[]{1,3,4,6};
		System.out.println(s.searchInsert(nums, 5));
	}
}
