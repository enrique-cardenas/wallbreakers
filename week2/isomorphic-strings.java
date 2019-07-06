class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sMap.containsKey(sChar) && sMap.get(sChar) != tChar){
                return false;
            }
            if(tMap.containsKey(tChar) && tMap.get(tChar) != sChar){
                return false;
            }
            else{
                sMap.put(sChar, tChar);
                tMap.put(tChar, sChar);
            }
        }
        
        return true;
    }
}