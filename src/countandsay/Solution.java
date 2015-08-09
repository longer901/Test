package countandsay;

public class Solution {

	 public String countAndSay(int n) {
		 if(n<=0)
			 return "";
		 String res= "1";
		 int count = 1;
		 while(count<n){
			 String tem = "";
			 char mark = res.charAt(0);
			 int num = 0;
			 for(int i=0;i<res.length();i++){
				 if(mark==res.charAt(i)){
					 num++;
					 if(i+1>=res.length()||mark!=res.charAt(i+1)){
						 tem += num+""+mark;
						 if(i+1<res.length())
							 mark = res.charAt(i+1);
						 num = 0;
					 }
				 }
			 }
			 res = tem;
			 count++;
		 }
		 return  res;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.countAndSay(8));
	}

}
