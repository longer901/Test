package lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	 public int lengthOfLongestSubstring(String s) {
         int start = 0;
		 int maxLen = 0;
         char[] array = s.toCharArray();
         Set<Character> set = new HashSet<Character>();
         for(int i=0;i<array.length;){
        	 if(!set.contains(array[i])){
        		 set.add(array[i]);
        		 i++;
        	 }else{
        		 set.remove(array[start]);
        		 start++;
        	 }
        	 maxLen = set.size()>=maxLen?set.size():maxLen;
         }
         return maxLen;
	 }
	 
	 public static void main(String[] args){
		 Solution s = new Solution();
		 System.out.println(s.lengthOfLongestSubstring("abbaccabcababcba"));
	 }
}
