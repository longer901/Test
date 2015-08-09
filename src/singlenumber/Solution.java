package singlenumber;

public class Solution {
	//²Î¿¼´ð°¸
    public int singleNumber(int[] nums) {
        int x = 0;
    	for (int a : nums) {
    		x = x ^ a;
    	}
    	return x;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
