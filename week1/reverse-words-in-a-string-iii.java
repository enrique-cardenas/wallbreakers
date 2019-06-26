class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sol = new StringBuilder();
        String[] split = s.split("\\s");
        
        for(int i = 0; i < split.length; i++){
            String current = split[i];
            for(int j = current.length() - 1; j >= 0; j--){
                sol.append(current.charAt(j));
            }
            if(i != split.length - 1){
                sol.append(" ");
            }
        }
        
        return sol.toString();
    }
}