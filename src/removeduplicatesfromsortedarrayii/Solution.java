package removeduplicatesfromsortedarrayii;



public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
        	return 0;
        int count = 1;
        int len = nums.length;
        int flag = 0;
        for(int i=1;i<len;){
        	if(nums[i-1]==nums[i]){
        		flag++;
        		if(flag==2){
	        		for(int j=i;j<len-1;j++){
	        			nums[j] = nums[j+1];
	        		}
	    			len--;
	    			flag--;
            	}else{
    	        	count++;
            		i++;
            	}
        	}else{
	        	flag = 0;
	        	count++;
	        	i=count;
        	}
        }
        return count;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {0,1,4,2,3};
		System.out.println(s.removeDuplicates(nums));
	}
}

