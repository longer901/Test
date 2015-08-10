package romantointeger;

import java.util.HashMap;

public class Solution {
	
    public int romanToInt(String s) {
    	if(s==null||s.length()==0)
    		return 0;
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>(); 
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	int res = 0;
    	for(int i=s.length()-1;i>=0;i--){
    		if(i==0||map.get(s.charAt(i))<=map.get(s.charAt(i-1))){
    			res += map.get(s.charAt(i));
    		}else{
    			res += map.get(s.charAt(i))-map.get(s.charAt(i-1));
    			i--;
    		}
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		//"DCXXI" - 621
		//"MCMXCVI" - 1996
		System.out.println(s.romanToInt("DCXXI"));
	}

}
