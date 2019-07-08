class Trie {
    
    final int ALPHABET_SIZE = 26;
    TrieNode root;
 
    class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
        boolean isEndOfWord; 
        
		TrieNode(){ 
			isEndOfWord = false; 
			for (int i = 0; i < ALPHABET_SIZE; i++) 
				children[i] = null; 
		} 
    }
    

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    
    
    /** Inserts a word into the trie. */
    public void insert(String key) {
        
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String key) {
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
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int level;
        int length = prefix.length();
        int index;
        TrieNode pCrawl = root;
        for(level = 0; level < length; level++){
            
            index = prefix.charAt(level) - 'a';
            
            if(pCrawl.children[index] == null){
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return true;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */