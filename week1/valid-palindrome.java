class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        String newString = s.replaceAll("\\s|\\W", "").toLowerCase();
        int length = newString.length();
        for(int i = 0; i < length / 2; i++){
            if(newString.charAt(i) != newString.charAt(length - i - 1)){
                return false;
            }
        }
        return true;
    }
}