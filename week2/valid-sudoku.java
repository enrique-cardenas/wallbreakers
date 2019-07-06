class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++){
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> subBox = new HashSet<>();
            
            int subBoxRow = 0;
            int subBoxCol = (i % 3) * 3;
            
            if(i >= 3) subBoxRow = 3;
            if(i >= 6) subBoxRow = 6;
            
            for(int j = 0; j < board[i].length; j++){
                
                // check row set
                if(board[i][j] != '.' && rowSet.contains(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.'){
                    rowSet.add(board[i][j]);
                }
                
                // check column set 
                if(board[j][i] != '.' && colSet.contains(board[j][i])){
                    
                    return false;
                }
                if(board[j][i] != '.'){
                    colSet.add(board[j][i]);
                }
                
                // check sub box set
                if(j > 0 && j % 3 == 0){
                    subBoxRow++;
                }
                
                int col = j % 3;
                col += subBoxCol;
                
                if(board[subBoxRow][col] != '.' && subBox.contains(board[subBoxRow][col])){
                    return false;
                }
                
                if(board[subBoxRow][col] != '.'){
                    subBox.add(board[subBoxRow][col]);
                }
            }
        }
        
        return true;
    }
}