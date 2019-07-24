class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int currentQ;
    int size;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
        currentQ = 1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(currentQ == 1){
            q1.add(x);
        }else{
            q2.add(x);
        }
        top = x;
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int popped = 0;
        if(currentQ == 1){
            while(q1.size() != 1){
                if(q1.size() == 2) top = q1.peek();
                q2.add(q1.remove());
            }
            popped = q1.remove();
            currentQ = 2;
        }
        else{
            while(q2.size() != 1){
                if(q2.size() == 2) top = q2.peek();
                q1.add(q2.remove());
            }
            popped = q2.remove();
            currentQ = 1;
        }
        size--;
        return popped;
    }
    
    /** Get the top element. */
    public int top() {
        if(size == 1){
            return currentQ == 1 ? q1.peek() : q2.peek();
        }
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(currentQ == 1){
            return q1.isEmpty();
        }
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */