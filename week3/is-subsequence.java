class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int pt2 = 0;
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            boolean found = false;
            for(int j = pt2; j < t.length(); j++){
                if(current == t.charAt(j)){
                    pt2 = j + 1;
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;
    }
}