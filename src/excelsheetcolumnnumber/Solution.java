package excelsheetcolumnnumber;

public class Solution {
    public int titleToNumber(String s) {
        if(s==null||s.length()==0)
        	return 0;
        int sum = 0;
        for(int i=s.length()-1,count = 0;i>=0;i--,count++){
        	sum +=(int)Math.pow(26, count)*(s.charAt(i)-'A'+1);
        }
        return sum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.titleToNumber("A"));
	}

}
