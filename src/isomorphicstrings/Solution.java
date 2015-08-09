package isomorphicstrings;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
    	if(s==null||t==null||s.length()!=t.length())
    		return false;
    	HashMap<Character,Character> dict = new HashMap<Character,Character>();
    	for(int i=0;i<s.length();i++){
    		char k = s.charAt(i);
			char v = t.charAt(i);
    		if(!dict.containsKey(k)){
    			if(dict.containsValue(v))
    				return false;
    			dict.put(k, v);
    		}else{
    			if(v!=dict.get(k))
    				return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isIsomorphic("paper", "title"));
	}
}
