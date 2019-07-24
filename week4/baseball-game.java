class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        int score = 0;
        int num;
        for(String cur : ops){
            if(cur.equals("+")){
                int top = stack.pop();
                num = top + stack.peek();
                score += num;
                stack.push(top);
                stack.push(num);
            }
            else if(cur.equals("D")){
                num = stack.peek() * 2;
                score += num;
                stack.push(num);
            }
            else if(cur.equals("C")){
                score -= stack.pop();
            }
            else{
                num = Integer.valueOf(cur);
                score += num;
                stack.push(num);
            }
        }
        return score;
    }
}