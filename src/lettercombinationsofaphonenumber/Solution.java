package lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;


public class Solution {
	public String[] map = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public String digits = null;
	public int length = 0;
	public char[] res = null;
	public List<String> resList = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {	
		this.digits = digits;
		length = digits.length();
		res = new char[length];
		backTrack(0);
		return resList;
	}
	
	public void backTrack(int k){
		if(k>=length){
			if(res.length!=0)
				resList.add(new String(res));
		}else{
			int n = Integer.valueOf(""+digits.charAt(k));
			for(int i=0;i<map[n].length();i++){
				res[k]=map[n].charAt(i);
				backTrack(k+1);
			}
		}
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println((s.letterCombinations("")).size());
	}
}
