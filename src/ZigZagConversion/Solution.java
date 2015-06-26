package ZigZagConversion;

public class Solution {
    public String convert(String s, int numRows) {
    	if(numRows==0||numRows==1||s.length()<=numRows){
    		return s;
    	}
    	char[] array = s.toCharArray();
    	int len = array.length;
    	char[] res = new char[len];
    	int k =0 ;
    	for(int i=0;i<numRows;i++){
			int gap = 2*numRows-2; 
    		for(int j=i;j<len;){
				res[k++]=array[j];
				if(i != 0 && i != numRows-1){
					int n = gap + j - 2*i;
					if(n>=len)
						break;
					res[k++] = array[n];
				}
    			j+=gap;
    		}
    	}
        return new String(res);
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.convert("0123456789", 4));
    }
}
