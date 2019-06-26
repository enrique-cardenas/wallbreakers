class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>(); // char -> # of time it appears
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++){
            char curr = t.charAt(i);
            if(!map.containsKey(curr)) return false;
            
            map.put(curr, map.get(curr) - 1);
            if(map.get(curr) < 0) return false;
        }
        return true;
    }
}