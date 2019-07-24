class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {        
        Deque<Integer> firstStack = new LinkedList<>();
        Deque<Integer> secondStack = new LinkedList<>();

        for(int num : nums2){
            firstStack.push(num);
        }
        
        int[] answer = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int cur = nums1[i];
            if(firstStack.peek() == cur)
                answer[i] = -1;
            
            while(firstStack.peek() != cur){
                secondStack.push(firstStack.pop());
            }
            
            // next greater element
            while(!secondStack.isEmpty() && secondStack.peek() < cur){
                firstStack.push(secondStack.pop());
            }
            
            if(secondStack.isEmpty()) answer[i] = -1;
            else answer[i] = secondStack.peek();
            
            // refill first stack
            while(!secondStack.isEmpty()){
                firstStack.push(secondStack.pop());
            }
        }
        return answer;
    }
}