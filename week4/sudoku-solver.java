class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(0, 0, board);
    }
    
    public boolean solveSudoku(int row, int col, char[][] board){
        if(col == board.length){
            col = 0;
            row++;
            
            if(row == board.length) return true;
        }
        
        if(board[row][col] != '.') return solveSudoku(row, col + 1, board);
        
        for(int i = 1; i <= 9; i++){
            char c = (char) (i + '0');
            
            if(isValidMove(row, col, c, board)){
                board[row][col] = c;
                if(solveSudoku(row, col + 1, board)) return true;
            }
        }
        board[row][col] = '.';
        return false;
    }
    
    public boolean isValidMove(int row, int col, char c, char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[(i / 3) + ((row / 3) * 3) ][(i % 3) + ((col / 3) * 3)] == c) return false;
        }
        return true;
    }
}