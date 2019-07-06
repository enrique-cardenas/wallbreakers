class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sFreqs = new HashMap<>();
        for(char c: s.toCharArray()){
            sFreqs.put(c, sFreqs.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> tFreqs = new HashMap<>();
        for(char c: t.toCharArray()){
            tFreqs.put(c, tFreqs.getOrDefault(c, 0) + 1);
        }
        
        for(char key: tFreqs.keySet()){
            if(!sFreqs.containsKey(key) || sFreqs.get(key) < tFreqs.get(key)){
                return key;
            }
        }
        return 'a';
    }
}