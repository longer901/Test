package reversebits;

public class Solution {
	
    public int reverseBits(int n) {
    	int res = 0;
    	for(int i=1;i<=32;i++){
    		int m = n&1;
    		if(m==1)
    			res += m<<(32-i);
    		n = n>>>1;
    	}
    	return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverseBits(43261596));
	}
}
