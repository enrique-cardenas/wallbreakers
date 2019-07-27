class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i = 0; i < memo.length; i++) Arrays.fill(memo[i], -1);
        return minDistance(word1, word1.length() - 1, word2, word2.length() - 1, memo);
    }
    
    public int minDistance(String word1, int word1Index, String word2, int word2Index, int[][] memo){
       
        // if word1 is empty, then you would insert remaining word2 substring length and
        // perform word2 substring length insertion operations
        if(word1Index < 0) return word2Index + 1;
        
        // if word2 is empty then you would delete remaining word1 substring length and 
        // perform word1 substring length delete operations
        if(word2Index < 0) return word1Index + 1;
        
        if(memo[word1Index][word2Index] == -1){
            
            if(word1.charAt(word1Index) == word2.charAt(word2Index))
                memo[word1Index][word2Index] = minDistance(word1, word1Index - 1, word2, 
                                                           word2Index - 1, memo);
            else{
                int insert = minDistance(word1, word1Index, word2, word2Index - 1, memo);
                int delete = minDistance(word1, word1Index - 1, word2, word2Index, memo);
                int replace = minDistance(word1, word1Index - 1, word2, word2Index - 1, memo);
                
                memo[word1Index][word2Index] = 1 + Math.min(Math.min(insert, delete), replace);
            }
        }
        return memo[word1Index][word2Index];
    }
}