package majorityelement;

import java.util.Stack;

public class Solution {
	//1.sort之后 nums[nums.size() / 2]的数字
	//2.
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int n: nums){
        	if(stack.size()==0||stack.peek()==n)
        		stack.add(n);
        	else
        		stack.pop();
        }
        return stack.pop();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,2,3,4};
		Solution s = new Solution();
		System.out.println(s.majorityElement(nums));
	}

}
