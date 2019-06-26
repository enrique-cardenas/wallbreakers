class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return ;
        int[] parent = new int[board.length * board[0].length];
        Arrays.setAll(parent, i -> i);

       for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'O'){
                    union(i, j, i, j, parent, board[i].length);
                    if(j + 1 < board[i].length && board[i][j + 1] == 'O'){
                        union(i, j, i, j + 1, parent, board[i].length);
                    }
                    if(i + 1 < board.length && board[i + 1][j] == 'O'){
                        union(i, j, i + 1, j, parent, board[i].length);
                    }
                }                
            }
        }
        
        Set<Integer> ignoreSet = new HashSet<>();
        int x = 0;
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                ignoreSet.add(find(i, parent));
            }
            
            if(board[board.length - 1][i] == 'O'){
                x = ((board.length - 1) * board[0].length) + i;
                ignoreSet.add(find(x, parent));
            }
        }
        
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                x = i * board[i].length;
                ignoreSet.add( find( x, parent) );
            }

            if(board[i][board[i].length - 1] == 'O'){
                x = (i * board[i].length) + board[i].length - 1;
                ignoreSet.add( find(x, parent));
            }
        }
        
       for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                x = (i * board[i].length) + j;
                if(!ignoreSet.contains( find(x, parent)) ){
                    board[i][j] = 'X';
                }
            }
       }
        
    }
    
    public int find(int x, int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    
    public void union(int i1, int j1, int i2, int j2, int[] parent, int length){
        int x = (i1 * length) + j1;
        int y = (i2 * length) + j2;
        int x_root = find(x, parent);
        int y_root = find(y, parent);
        parent[x_root] = y_root;
    }
}