package validpalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null)
        	return false;
        if(s.equals(""))
        	return true;
        int b = 0;
        int e = s.length()-1;
        while(b<=e){
        	char one = s.charAt(b);
        	char two = s.charAt(e);
        	int onechar = checkchar(one);
        	int twochar = checkchar(two);
        	if(onechar==0||twochar==0){
        		if(onechar==0)
        			b++;
        		if(twochar==0)
        			e--;
        	}else{
        		one = onechar==1?(char)(one+32):one;
        		two = twochar==1?(char)(two+32):two;
        		if(one!=two)
        			return false;
        		b++;
        		e--;
        	}
        }
        return true;
    }
    public int checkchar(char s){
    	if(s>=48&&s<=57)
    		return 2;
    	if(s>=65&&s<=90)
    		return 1;
    	if(s>=97&&s<=122)
    		return -1;
    	return 0;
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome("123"));
	}
}
