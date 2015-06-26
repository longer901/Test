package validparentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	
    public boolean isValid(String s) {
    	if(s.length()<=1)
    		return false;
        List<Character> charSet = new ArrayList<Character>();
        charSet.add('(');
        charSet.add(')');
        charSet.add('[');
        charSet.add(']');
        charSet.add('{');
        charSet.add('}');
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	char now = s.charAt(i);
        	int  nv = charSet.indexOf(now);
        	if(nv%2==0){
        		stack.add(now);
        	}else{
        		if(stack.size()>0){
                	int	 tv = charSet.indexOf(stack.peek());
            		if(nv-tv==1)
            			stack.pop();
            		else
            			return false;
        		}else
        			return false;
        	}
        }
    	return stack.size()==0?true:false;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "([]({}))[}";
		System.out.println(s.isValid(str));
	}
}
