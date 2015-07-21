package implementstrstr;

public class Solution {
/*
 * 
 */
    public int strStr(String haystack, String needle) {
    	return haystack.indexOf(needle);
    }
    //"mississippi", "issipi"
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.strStr("mississipi", "issipi"));
	}

}
