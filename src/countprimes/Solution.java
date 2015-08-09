package countprimes;

public class Solution {
	//²Î¿¼´ð°¸
	public int len;
	public boolean[] mark ;
    public int countPrimes(int n) {
    	mark = new boolean[n+1];
        int count = 0;
        len = n;
        for(int i=2;i<n;i++){
        	if(mark[i])
        		continue;
        	trans(i);
        	count++;
        }
       return count;
    }
    public void trans(int n){
    	boolean flag = mark[n];
        if(!flag){
	        for(int k=2;n*k<=len;k++){
	        	mark[n*k] = true;
	        }
        }
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countPrimes(2));
	}
}
