class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        String[] splitString = str.split(" ");
        if(splitString.length != pattern.length()) return false;
        
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String string = splitString[i];
            
            if(map1.containsKey(c) && !map1.get(c).equals(string)){
                return false;
            }
            if(map2.containsKey(string) && map2.get(string) != c){
                return false;
            }
            map1.put(c, string);
            map2.put(string, c);
        }
        return true;   
    }
}