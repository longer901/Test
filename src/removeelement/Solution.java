package removeelement;

public class Solution {
    public int removeElement(int[] nums, int val) {
    	if(nums==null||nums.length==0)
    		return 0;
        int len = nums.length;
        int count = 0;
        for(int i=0;i<len;){
        	if(nums[i]==val){
        		for(int j = i+1;j<len;j++)
        			nums[j-1] = nums[j];
        		len--;
        		continue;
        	}
        	count++;
        	i=count;
        }
        return len;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2};
		System.out.println(s.removeElement(nums,2));
	}
}
