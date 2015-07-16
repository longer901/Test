package poweroftwo;

public class Solution {
    public boolean isPowerOfTwo(int n) {
    	while(n>1){
    		if(n%2!=0)
    			return false;
    		n=n/2;
    	}
    	return n<1;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPowerOfTwo(14));
	}
}
