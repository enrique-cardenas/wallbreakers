class Solution {
    public int scoreOfParentheses(String S) {
        
        Deque<Integer> stack = new LinkedList<>();
        int currentScore = 0;
        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(currentScore);
                currentScore = 0;
            }
            else{
                currentScore = Math.max(2 * currentScore, 1);
                currentScore += stack.pop();
            }
        }
        return currentScore;
    }
}