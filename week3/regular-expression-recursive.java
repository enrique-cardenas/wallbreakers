class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        int[][] memo = new int[s.length()][p.length()];
        for(int[] row: memo) Arrays.fill(row, -1);
        return isMatch(s, s.length() - 1, p, p.length() - 1, memo);
    }
    
    public boolean isMatch(String s, int sIndex, String p, int pIndex, int[][] memo){
        if(sIndex < 0 && pIndex < 0)return true;
        if(sIndex >= 0 && pIndex < 0) return false;
        if(sIndex < 0 && pIndex >= 0){
            while(pIndex >= 0){
                if(p.charAt(pIndex) != '*') return false;
                pIndex -= 2;
            }
            return true;
        }
        boolean answer = false;
        
        if(memo[sIndex][pIndex] == -1){
            if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.'){
                answer = isMatch(s, sIndex - 1, p, pIndex - 1, memo);
                memo[sIndex][pIndex] = answer ? 1 : 0;
            }
            else if(p.charAt(pIndex) == '*'){
                if(p.charAt(pIndex - 1) == '.' || p.charAt(pIndex - 1) == s.charAt(sIndex)){
                    answer = isMatch(s, sIndex - 1, p, pIndex, memo) ||
                            isMatch(s, sIndex - 1, p, pIndex - 2, memo) ||
                            isMatch(s, sIndex, p, pIndex - 2, memo);
                    memo[sIndex][pIndex] = answer ? 1 : 0;
                }
                else{
                    answer = isMatch(s, sIndex, p, pIndex - 2, memo); 
                    memo[sIndex][pIndex] = answer ? 1 : 0;
                }
            }
            else{
                answer = false;
                memo[sIndex][pIndex] = answer ? 1 : 0;
            }
        }
        if(memo[sIndex][pIndex] == 0) answer = false;
        if(memo[sIndex][pIndex] == 1) answer = true;;
        
        return answer;
    }
}