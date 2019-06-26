class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < strs[0].length(); i++){
            char curr = strs[0].charAt(i);
            
            boolean flag = true;
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != curr){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer.append(curr);
            }
            else break;
        }
        
        return answer.toString();
    }
}