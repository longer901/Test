package findpeakelement;

public class Solution {
	//²Î¿¼
//    public int findPeakElement(int[] nums) {
//    	int x = 0;
//    	for (int a : nums) {
//    		x = x ^ a;
//    	}
//    	return x;
//    }
	
    public int findPeakElement(int[] nums) {
    	int res = 0;
        for(int i=0;i<nums.length;i++){
        	if(i-1>=0&&nums[i]<=nums[i-1]){
        		continue;
        	}
        	if(i+1<nums.length&&nums[i]<=nums[i+1]){
        		continue;
        	}
        	res = i;
        	break;
        }
        return res;
    }

//	public int findPeakElement(int[] num) {
//		int l = 0;
//		int r = num.length - 1;
//		int mid = r / 2;
//		while (l < r) {
//			if (num[mid] < num[mid + 1]) {
//				l = mid + 1;
//			} else {
//				r = mid;
//			}
//			mid = (l + r) / 2;
//		}
//		return l;
//	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[]{1};
		System.out.println(s.findPeakElement(nums));
	}
}
