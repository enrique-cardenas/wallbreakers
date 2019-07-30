class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, word, 0, visited)) return true;
                }
            }
        }
        return false;
    }
                
    
    public boolean dfs(char[][] board, int i, int j, String word, int wordIndex, boolean[][] visited) {
        if(wordIndex == word.length() - 1) return true;
        
        visited[i][j] = true;
        char cur = board[i][j];
        char nextChar = word.charAt(wordIndex + 1);
        
        boolean result = false;
        
        if(j > 0 && board[i][j-1] == nextChar && !visited[i][j-1])
            result = result || dfs(board, i, j-1, word, wordIndex + 1, visited);
            
        if(j < board[i].length - 1 && board[i][j+1] == nextChar && !visited[i][j+1])
            result = result || dfs(board, i, j+1, word, wordIndex + 1, visited);
            
        if(i > 0 && board[i-1][j] == nextChar && !visited[i-1][j])
            result = result || dfs(board, i-1, j, word, wordIndex + 1, visited);
            
        if(i < board.length - 1 && board[i+1][j] == nextChar && !visited[i+1][j])
            result = result || dfs(board, i+1, j, word, wordIndex + 1, visited);
        
        visited[i][j] = false;
        return result;
    }
}