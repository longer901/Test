package excelsheetcolumntitle;

public class Solution {
	//实质是10进制和26进制互转
    public String convertToTitle(int n) {
        String res = "";
        while(n>0){
        	n=n-1;
        	res = (char)(n%26+'A')+res; 
        	n = n/26;
        }
        return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.convertToTitle(1));
	}
}
