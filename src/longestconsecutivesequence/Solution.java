package longestconsecutivesequence;

import java.util.TreeSet;

public class Solution {

	//��ĿҪ������O��n�������Ǳ��ⷨ����TreeMap�����������֪��������������Ӷ��Ƕ���
    public int longestConsecutive(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
       TreeSet<Integer> set = new TreeSet<Integer>();
       for(int h : nums)
    	   set.add(h);
       int max= 0;
       int t = 1;
       int before = Integer.MAX_VALUE;
       for(int i: set){
    	   if(before+1==i)
    		   t++;
    	   else
    		   t=1;
		   if(t>max)
			   max = t;
    	   before = i;
       }
       return max;
    }
    
    //�ο��ǳ��õ�python�㷨
//    def longestConsecutive(self, nums):
//        nums = set(nums)
//        best = 0
//        for n in nums:
//            if n - 1 not in nums:
//                m = n + 1
//                while m in nums:
//                    m += 1
//                best = max(best, m - n)
//        return best
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = new int[]{0,-1};
		System.out.println(s.longestConsecutive(nums));
	}

}
