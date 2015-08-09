package singlenumberii;

public class Solution {
	//参考答案
    public int singleNumber(int[] nums) {
	   int[] bitnum= new int[32];
       int res=0;
       for(int i=0; i<32; i++){
           for(int n : nums){
               bitnum[i]+=(n>>i)&1;
           }
           res|=(bitnum[i]%3)<<i;
       }
       return res; 
    }
    //还有更快算法
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {12,12,3,12};
		System.out.println(s.singleNumber(nums));
	}

}
