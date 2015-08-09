package numberof1bits;

public class Solution {
	//²Î¿¼´ð°¸
    public int hammingWeight(int n) {
        int counter = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                counter += 1;
            }
            n >>>= 1;
        }
        return counter;
    }
//    public int hammingWeight(int n) {
//        int count = 0;
//        for (; n != 0; n >>>= 1)
//            count += 1 & n;
//
//        return count;
//    }
    //  2147483648 (10000000000000000000000000000000)
    public static void main(String[] args) {
		Solution s = new Solution();
		//2147483648
		System.out.println(s.hammingWeight(0));
	}
}
