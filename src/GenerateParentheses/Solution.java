package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;


public class Solution {
	
	public int strLen = 0;
	public String oneRes = "(";
	public int stack = 0;
	public char[] chars = new char[]{'(',')'};
	public List<String> res = new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		if(n==0){
			return res;
		}
        strLen = n*2;
        stack = 1;
        backTrack(2);
		return res;
    }
	
	public void backTrack(int k){
		if(k>strLen){
			if(stack==0){
				res.add(new String(oneRes));
				System.out.println(oneRes);
			}
		}else{
			for(int i=0;i<chars.length;i++){
				oneRes += chars[i];
				if(chars[i]==chars[0]){
					stack++;
					backTrack(k+1);
					stack--;
				}else if(stack>0&&chars[i]==chars[1]){
					stack--;
					backTrack(k+1);
					stack++;
				}
				oneRes = oneRes.substring(0, oneRes.length()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println((s.generateParenthesis(3)).size());
	}
}
