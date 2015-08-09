package plusone;

public class Solution {

    public int[] plusOne(int[] digits) {
       int[] res = null;
       if(digits==null||digits.length==0){
    	   res = new int[]{1};
    	   return res;
       }
       int carry = 1;
       for(int i=digits.length-1;i>=0;i--){
    	   digits[i] += carry;
    	   int chu = digits[i]/10;
    	   carry = chu==0?0:1;
    	   digits[i] %= 10;
       }
       if(carry==1){
    	   res = new int[digits.length+1];
    	   res[0] = 1;
    	   System.arraycopy(digits,0,res,1,digits.length);
    	   return res;
       }
       return digits;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] digits = new int[]{9,9};
		for(int n:s.plusOne(digits))
		System.out.println(n);		
	}

}
