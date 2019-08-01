class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        Trie.TrieNode root = trie.root;
        
        Set<String> answer = new HashSet<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char cur = board[i][j];
                if(root.children[cur - 'a'] != null){
                    StringBuilder word = new StringBuilder();
                    dfs(board, i, j, root, word, 
                        new boolean[board.length][board[i].length], answer);
                }
            }
        }
        return new ArrayList<>(answer); 
    }
    
    public void dfs(char[][] board, int i, int j, Trie.TrieNode root, StringBuilder word, boolean[][] visited, Set<String> answer){
        
        visited[i][j] = true;
        char cur = board[i][j];
        word.append(cur);
        root = root.children[cur - 'a'];
        
        if(root.isEndOfWord){
            answer.add(word.toString());
        }
        
        char left = j > 0 ? board[i][j-1] : 0;
        if(left != 0 && root.children[left - 'a'] != null && !visited[i][j-1])
            dfs(board, i, j-1, root, word, visited, answer);
        
        char right = j < board[i].length - 1 ? board[i][j+1] : 0;
        if(right != 0 && root.children[right - 'a'] != null && !visited[i][j+1])
            dfs(board, i, j+1, root, word, visited, answer);
        
        char top = i > 0 ? board[i-1][j] : 0;
        if(top != 0 && root.children[top - 'a'] != null && !visited[i-1][j])
            dfs(board, i-1, j, root, word, visited, answer);
        
        char bot = i < board.length - 1 ? board[i+1][j] : 0;
        if(bot != 0 && root.children[bot - 'a'] != null && !visited[i+1][j])
            dfs(board, i+1, j, root, word, visited, answer);
            
        visited[i][j] = false;
        word.deleteCharAt(word.length() - 1);
    }
}

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
}