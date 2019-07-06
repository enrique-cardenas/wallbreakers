class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> freqs = new HashMap<>();
        for(char c: s.toCharArray()){
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            if(freqs.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}