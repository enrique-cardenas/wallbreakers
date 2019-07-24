class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, result, new StringBuilder(), 0, 0);
        return result;
    }
    
    public void generateParenthesis(int n, List<String> result, StringBuilder paren, 
                                    int open, int close){
        if(paren.length() == n * 2){
            result.add(paren.toString());
        }
        else{
            if(open < n){
                paren.append("(");
                generateParenthesis(n, result, paren, open + 1, close);
                paren.deleteCharAt(paren.length() - 1);
            }
            if(close < open){
                paren.append(")");
                generateParenthesis(n, result, paren, open, close + 1);
                paren.deleteCharAt(paren.length() - 1);
            }   
        }
    }
}