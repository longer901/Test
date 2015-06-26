package houserobber;

//求数组中不相邻数据进行组合得到的最大值
public class Solution {
    public int rob(int[] nums) {
    	if(nums.length==0)
    		return 0;
        int[] max = new int[nums.length];//max[i]  max chain value from 0-i
        int[] pos = new int[nums.length];//pos[i]  pos of max value before i
        max[0] = nums[0];
        pos[0] = 0;
        for(int i =1;i<nums.length;i++){
        	int maxpre = i-2>=0?max[pos[i-2]]:0;
        	max[i] = maxpre+nums[i];
        	System.out.println(max[i]);
        	pos[i] = max[i]<max[pos[i-1]]?pos[i-1]:i;
        }
        return max[pos[nums.length-1]];
    }
	public static void main(String[] args) {
		int[] par = new int[] { 2,1,1,1,2};
		Solution s = new Solution();
		System.out.println(s.rob(par));
	}
}
