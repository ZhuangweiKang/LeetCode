import java.util.Stack;

/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        helper = new Stack<>();
        while (!this.stack.isEmpty()){
            Integer top = stack.peek();
            stack.pop();
            helper.push(top);
        }
        int result = helper.peek();
        helper.pop();
        while (!helper.isEmpty()){
            stack.push(helper.peek());
            helper.pop();
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        helper = new Stack<>();
        while (!this.stack.isEmpty()){
            Integer top = stack.peek();
            stack.pop();
            helper.push(top);
        }
        int result = helper.peek();
        while (!helper.isEmpty()){
            stack.push(helper.peek());
            helper.pop();
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}