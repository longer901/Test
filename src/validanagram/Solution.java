package validanagram;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s.length()!=t.length())
    		return false;
    	if(s.equals(t))
    		return true;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
        	boolean flag = map.containsKey(s.charAt(i));
        	if(flag){
        		map.put(s.charAt(i), map.get(s.charAt(i))+1);
        	}else if(!flag){
        		map.put(s.charAt(i), 1);
        	}
        	boolean flag2 = map.containsKey(t.charAt(i));
        	if(flag2){
        		map.put(t.charAt(i), map.get(t.charAt(i))-1);
        	}else if(!flag2){
        		map.put(t.charAt(i), -1);
        	}
        }
        for(Character c : map.keySet()){
        	if(map.get(c)!=0)
        		return false;
        }
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isAnagram("", ""));
	}

}
