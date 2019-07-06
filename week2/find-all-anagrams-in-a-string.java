class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> answer = new ArrayList<>();
        
        Map<Character, Integer> pFrequencies = new HashMap<>();
        for(char c : p.toCharArray()){
            pFrequencies.put(c, pFrequencies.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> currFrequencies = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            if(i >= p.length()){
                int startIndex = i - p.length();
                char startChar = s.charAt(startIndex);
                currFrequencies.put(startChar, currFrequencies.get(startChar) - 1);
                if(currFrequencies.get(startChar) == 0){
                    currFrequencies.remove(startChar);
                }
            }

            char c = s.charAt(i);
            currFrequencies.put(c, currFrequencies.getOrDefault(c, 0) + 1);
            
            if(currFrequencies.equals(pFrequencies)){   
                int startIndex = i - p.length() + 1;
                answer.add(startIndex);
            }
        }
        
        return answer;
    }
}