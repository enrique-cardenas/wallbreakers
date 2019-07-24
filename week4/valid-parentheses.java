class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            
            if(stack.isEmpty()) return false;
            if(c == ')'){
                if(stack.pop() != '(') return false;
            }
            if(c == ']'){
                if(stack.pop() != '[') return false;
            }
            if(c == '}'){
                if(stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}