import java.util.LinkedList;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> helper;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        helper = new LinkedList<>();
        while (!queue.isEmpty()){
            helper.add(queue.poll());
        }
        while (helper.size() > 1){
            queue.add(helper.poll());
        }
        return helper.poll();
    }

    /** Get the top element. */
    public int top() {
        helper = new LinkedList<>();
        while (!queue.isEmpty()){
            helper.add(queue.poll());
        }
        while (helper.size() > 1){
            queue.add(helper.poll());
        }
        queue.add(helper.peek());
        return helper.poll();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}