package addtwonumbers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
	}
public class Solution {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
    	ListNode resNext = null;
    	boolean first = true;
    	int carry = 0;
    	if(l1==null&&l2==null){
    		return null;
    	}
    	while(true){
    		int nowValue = 0;
    		if(l1!=null){
    			nowValue += l1.val;
    			l1 = l1.next;
    		}
    		if(l2!=null){
    			nowValue += l2.val;
    			l2 = l2.next;
    		}
    		nowValue += carry;
    		carry = nowValue/10;
    		nowValue = nowValue%10;
    		if(first){
    			resNext = new ListNode(nowValue);
    			res = resNext;
    			first = false;
    		}else{
    			resNext.next = new ListNode(nowValue);
    			resNext = resNext.next;
    		}
    		if(l2==null&&l1==null&&carry==0){
    			break;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	ListNode l1 = new ListNode(5);
//    	ListNode t2 = new ListNode(0);
//    	ListNode t3 = new ListNode(3);
//    	l1.next = t2;
//    	t2.next = t3;
    	
    	ListNode l2 = new ListNode(5);
//    	ListNode k2 = new ListNode(0);
//    	ListNode k3 = new ListNode(6);
//    	l2.next = k2;
//    	k2.next = k3;   
    	
//    	ListNode l3 = addTwoNumbers(l1,l2);
//    	while(true){
//    		System.out.println(l3.val);
//    		l3 = l3.next;
//    		if(l3==null){
//    			break;
//    		}
//    	}
    }
}