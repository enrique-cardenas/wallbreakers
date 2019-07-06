class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> transformations = new HashSet<>();
        
        for(int i = 0; i < words.length; i++){
            StringBuilder wordToMorse = new StringBuilder();
            for(char c : words[i].toCharArray()){
                wordToMorse.append(morse[c - 'a']);
            }
            transformations.add(wordToMorse.toString());
        }
        return transformations.size();
    }
}