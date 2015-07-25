package addbinary;

public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||a.equals(""))
        	return a;
        if(b==null||b.equals(""))
        	return b;
        int carry = 0;
        String s = "";
        int len = Math.max(a.length(), b.length());
        for(int i =0 ; i<len;i++){
        	int n1 = a.length()-1-i>=0?(a.charAt(a.length()-1-i)-'0'):0;
        	int n2 = b.length()-1-i>=0?(b.charAt(b.length()-1-i)-'0'):0;
        	int sum = n1+n2+carry;
        	if(sum>=2){
        		carry = 1;
        		sum = sum-2;
        	}else{
        		carry=0;
        	}
        	s = sum+s;
        }
        if(carry==1)
        	s = 1+s;
        int i = 0;
        for(;i<s.length();i++){
        	if(s.charAt(i)!='0')
        		break;
        }
        return "".equals(s.substring(i))?"0":s.substring(i);
    }
    public static void main(String[] args) {
		Solution s =  new Solution();
		System.out.println(s.addBinary("0", "0"));
	}
}
