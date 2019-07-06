class Solution {
    public String frequencySort(String s) {
        if(s.length() == 0) return "";
        
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(char c: s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if(freq.get(c) > maxFreq){
                maxFreq = freq.get(c);
            }            
        }
        
        ArrayList<Character>[] frequencies = new ArrayList[maxFreq + 1];
        for(char key: freq.keySet()){
            int index = freq.get(key);
            if(frequencies[index] == null){
                frequencies[index] = new ArrayList<>();
            }
            frequencies[index].add(key);
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = maxFreq; i > 0; i--){
            if(frequencies[i] == null) continue ;
            for(char c: frequencies[i]){
                for(int j = 0; j < i; j++){
                    answer.append(c);
                }
                
            }
        }
        
        return answer.toString();
    }
}