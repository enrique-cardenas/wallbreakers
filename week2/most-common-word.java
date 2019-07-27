class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(String word: banned){
            word = word.toLowerCase();
            bannedSet.add(word);
        }
        
        Map<String, Integer> wordFreqs = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String mostCommonWord = "";
        String[] splitParagraph = paragraph.split("[\\s+\\!|\\?|'|,|;|\\.]+");
        
        for(String word: splitParagraph){
            
            word = word.toLowerCase();
            if(!bannedSet.contains(word)){
                wordFreqs.put(word, wordFreqs.getOrDefault(word, 0) + 1);
                if(wordFreqs.get(word) > max){
                    max = wordFreqs.get(word);
                    mostCommonWord = word;
                }
            }
        }
        
        return mostCommonWord;
    }
}