package lengthoflastword;

public class Solution {

    public int lengthOfLastWord(String s) {
        if(s==null||s.equals(""))
        	return 0;
        int len = 0;
        boolean pre = false;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)!=' '){
        		if(pre)
        			len=0;
        		len++;
        		pre = false;
        	}else{
        		pre = true;
        	}
        }
        return len;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.lengthOfLastWord("a sd"));
	}

}
