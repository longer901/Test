package factorialtrailingzeroes;

public class Solution {
	//²Î¿¼´ð°¸
    public int trailingZeroes(int n) {
    	if(n<5)
    		return 0;
    	int sum = 0;
    	while(n!=0){
    		n = n/5;
    		sum += n;
    	}
    	return sum;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.trailingZeroes(25));
	}
}
