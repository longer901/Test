package CompareVersionNumbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
    	int length = v1.length>v2.length?v1.length:v2.length;
    	int v = 0;
    	for(int i=0 ;i<length;i++){
        	int t1 = v1.length<=i?0:Integer.valueOf(v1[i]);
        	int t2 = v2.length<=i?0:Integer.valueOf(v2[i]);
        	v = compare(t1,t2);
        	if(v!=0)
        		break;
    	}
        return v;
    }
    public int compare(int a , int b){
    	return a>b?1:(a<b?-1:0);
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.compareVersion("01", "1"));
    }
}