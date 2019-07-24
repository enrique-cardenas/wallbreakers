class MyQueue {
    
    Deque<Integer> firstStack;
    Deque<Integer> secondStack;
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        firstStack = new LinkedList<>();
        secondStack = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(firstStack.isEmpty()) front = x;
        firstStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(firstStack.size() != 1){
            secondStack.push(firstStack.pop());
        }
        int toPop = firstStack.pop();
        
        if(!secondStack.isEmpty())
            front = secondStack.peek();
        
        while(!secondStack.isEmpty()){
            firstStack.push(secondStack.pop());
        }
        return toPop;
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */