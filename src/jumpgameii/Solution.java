package jumpgameii;

public class Solution {

	 public  int jump(int[] A) {
	        int ret = 0;//��ǰ����
	        int last = 0;//��һ���ɴ���Զ����
	        int curr = 0;//��ǰһ���ɴ���Զ��
	        int n = A.length;
	        for (int i = 0; i < n; ++i) {
	            //�޷���ǰ����ֱ�ӷ���
	            if(i>curr){
	                return -1;
	            }
	            //��Ҫ�����´���Ծ�������last�͵�ִ�е�����ret
	            if (i > last) {
	                last = curr;
	                ++ret;
	            }
	            //��¼��ǰ�ɴ����Զ��
	            curr = Math.max(curr, i+A[i]);
	        }

	        return ret;
	    }
	public static void main(String[] args) {
		//1,2
		//2,3,1,1,4
		//3,2,1,0,4
		//1,2,3
		//1,3,2
		//2,3,1
		Solution s = new Solution();
		int[] nums = new int[]{2,3,1};
		System.out.println(s.jump(nums));
	}
}
