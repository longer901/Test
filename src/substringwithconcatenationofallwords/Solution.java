package substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	//²Î¿¼´ð°¸
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> res = new ArrayList<Integer>();
        if(s==null||words==null||s.length()==0||words.length==0)
        	return res;
        int wordLen = words[0].length();
        for(int start=0;start<wordLen;start++){
            List<String> dict = new LinkedList<String>(Arrays.asList(words));
        	int b = start;
        	int e = start;
        	while(b<=e&&b<=s.length()-wordLen&&e<=s.length()-wordLen){
        		String t = s.substring(e, e+wordLen);
        		int pos = dict.indexOf(t);
        		if(pos==-1){
        			if(b==e){
        				e += wordLen;
        			}else{
        				dict.add(s.substring(b, b+wordLen));
        			}
        			b += wordLen;
        		}else{
        			e += wordLen; 
        			dict.remove(pos);
            		if(dict.size()==0){
            			res.add(b);
            		}
        		}
        	}
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String ss = "barfoofoobarthefoobarman";
		String[] words= {"bar","foo","the"};
//		String ss = "sdfsbarfoothefoobarman";
//		String[] words = {"foo","bar"};
//		String ss = "aaaaaaaa";
//		String[] words = {"aa","aa","aa"};
//		String ss = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababaabababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
//		String[] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
		System.out.println(s.findSubstring(ss, words));
	}

}
