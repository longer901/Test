package rotatearray;

public class Solution {
	// 不是经典算法！！
    public void rotate(int[] nums, int k) {
    	if(k<=0)
    		return ;
    	k = k%nums.length;
    	int[] after = new int[k] ;
    	int last = nums.length-k-1;
    	System.arraycopy(nums,last+1,after,0,k);
    	System.arraycopy(nums,0,nums,k,nums.length-k);
    	System.arraycopy(after,0,nums,0,k);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		Solution s = new Solution();
		s.rotate(nums, 7);
		for(int n:nums){
			System.out.print(n+" ");
		}
	}

}
