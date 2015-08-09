package bitwiseandofnumbersrange;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	if(m==0||m==n)
    		return m;
    	int i = 30;
    	int k = 1;
    	while(i>=0){
    		k = 1<<i;
    		if((k&n)==k)
    			break;
    		i--;
    	}
    	int res = 0;
    	do{
    		if((k&m)!=(k&n))
    			return res;
    		res += k&m;
    		k = k>>1;
        	i--;
    	}while(i>=0);
    	return res;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		//600000000, 2147483645
		//0, 2147483647
		System.out.println(s.rangeBitwiseAnd(1,7));
	}
}
