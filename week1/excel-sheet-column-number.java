class Solution {
    public int titleToNumber(String s) {
        int sol = s.charAt(s.length() - 1) - 'A' + 1;
        int base = 1 * 26;
        for(int i = s.length() - 2; i >= 0; i--){
            sol += ((s.charAt(i) - 'A') + 1) * base;
            base *= 26;
        }
        
        return sol;
    }
}