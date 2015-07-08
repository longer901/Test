package implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

}

class MyStack {
    // Push element x onto stack.
	public Queue<Integer> queue = new LinkedList<Integer>();
	
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
       int i=queue.size();
       while(i!=1){
    	   queue.add(queue.poll());
    	   i--;  
       }
       queue.poll();
    }

    // Get the top element.
    public int top() {
        int i=queue.size();
        while(i!=1){
     	   queue.add(queue.poll());
     	   i--;  
        }
        int res = queue.poll();
        queue.add(res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}