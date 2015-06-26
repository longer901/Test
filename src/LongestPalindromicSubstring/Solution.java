package LongestPalindromicSubstring;

public class Solution {
	public static int start = 0;
	public static int end = 0;
	public static int length = 1;
    public String longestPalindrome(String s) {
    	String res = null;
    	if(s.length()==0||s.length()==1){
    	   return s;
    	} 
    	for(int i=0;i<s.length()-1;){
    		start = i;
			while(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
    			i++;
    		}
			end = i;
    		while(start>0&&end<s.length()-1&&s.charAt(start-1)==s.charAt(end+1)){
       			start--;
        		end++;
    		}
    		if(length<=end-start+1){
        		length = end-start+1;
            	res = s.substring(start,end+1);	
    		}
    		i++;
    	}
    	return res;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.longestPalindrome("aasaabbaabba"));
    }
}
