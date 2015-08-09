package multiplystrings;

public class Solution {
    public String multiply(String num1, String num2) {
    	if(num1.equals("0")||num2.equals("0"))
    		return "0";
    	if(num1.equals("1"))
    		return num2;
    	if(num2.equals("1"))
    		return num1;
        String large = num1;
        String small = num2;
        if(num1.length()<num2.length()){
            large = num2;
            small = num1;
        }
        String res = "";
        for(int j =small.length()-1 ;j>=0;j--){
        	int one = (small.charAt(j)-'0');
        	int sum = 0;
        	int carry = 0;
        	String t = "";
	        for(int i=large.length()-1;i>=0;i--){
	        	int a = large.charAt(i)-'0';
	        	sum = a*one;
	        	sum += carry;
	        	t = sum%10 + t;
	        	carry = sum/10;
	        }
	        if(carry!=0)
	        	t = carry+t;
	        for(int count = 0;count<small.length()-1-j;count++){
	        	t = t+"0";
	        }
	        res = addTwo(t,res);
        }
        return res;
    }
    public String addTwo(String a,String b){
    	if(a.equals("0"))
    		return b;
    	if(b.equals("0"))
    		return a;
    	String res = "";
    	String large = a;
    	String small = b;
    	if(a.length()<b.length()){
        	large = b;
        	small = a;
    	}
    	int carry = 0;
    	for(int i=large.length()-1,j=small.length()-1;i>=0;i--,j--){
    		int sum = large.charAt(i)-'0'+carry;
    		if(j>=0)
    			sum +=small.charAt(j)-'0';
    		carry = sum/10;
    		res = sum%10 + res;
    	}
    	return carry==0?res:carry+res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.multiply("581852037460725882246068583352420736139988952640866685633288423526139", "2723349969536684936041476639043426870967112972397011150925040382981287990380531232"));
	}

}
