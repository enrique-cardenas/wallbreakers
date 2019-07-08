class Solution {
    public String longestWord(String[] words) {
        
        TrieNode root = new TrieNode();
        
        // fill root with key nodes
        for(String word : words){
            insert(word, root);
        }
        
        int prevLen = -1;
        int maxLen = Integer.MIN_VALUE;
        String answer = "z";
        
        // find longest word in dictionary by making sure each word has
        // subwords in the dictionary
        for(String word : words){

            // flag to check if current word can be built off of smaller dictionary words
            boolean canBeBuilt = true;
            for(int i = 1; i <= word.length(); i++){
                String sub = word.substring(0, i);
                if(!search(sub, root)){
                    canBeBuilt = false;
                    break;
                }
            }
            
            // check if word is longer than previous acceptable word
            // or if word is smaller lexicographically
            if(canBeBuilt){
                if(word.length() == maxLen && word.compareTo(answer) < 0){
                    answer = word;
                }
                if(word.length() > maxLen){
                    maxLen = word.length();
                    answer = word;
                }   
            }
        }
         
        return answer;
    }
    
    

	// If not present, inserts key into trie 
	// If the key is prefix of trie node, 
	// just marks leaf node 
	public void insert(String key, TrieNode root) 
	{ 
		int level; 
		int length = key.length(); 
		int index; 
	
		TrieNode pCrawl = root; 
	
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - 'a'; 
			if (pCrawl.children[index] == null) 
				pCrawl.children[index] = new TrieNode(); 
	
			pCrawl = pCrawl.children[index]; 
		} 
	
		// mark last node as leaf 
		pCrawl.isEndOfWord = true; 
	}
    
    
	// Returns true if key presents in trie, else false 
	boolean search(String key, TrieNode root) 
	{ 
		int level; 
		int length = key.length(); 
		int index; 
		TrieNode pCrawl = root; 
	
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - 'a'; 
	
			if (pCrawl.children[index] == null) 
				return false; 
	
			pCrawl = pCrawl.children[index]; 
		} 
	
		return (pCrawl != null && pCrawl.isEndOfWord); 
	} 
    
}


// trie node 
class TrieNode { 
    int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 

    // isEndOfWord is true if the node represents 
    // end of a word 
    boolean isEndOfWord; 

    TrieNode(){ 
        isEndOfWord = false; 
        for (int i = 0; i < ALPHABET_SIZE; i++) 
            children[i] = null; 
    } 
}