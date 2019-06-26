class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++){
            
            for(int j = 0; j < grid[i].length; j++){
                
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    dfs(i, j, grid, visited);
                } 
                
            }
        }
        return islands;
    }
    
    public void dfs(int i, int j, char[][] grid, boolean[][] visited){
        if(grid[i][j] == '0' || visited[i][j]) return ;
        if(grid[i][j] == '1'){
            visited[i][j] = true;
        }
        if(j + 1 < grid[i].length) dfs(i, j + 1, grid, visited);
        if(i + 1 < grid.length) dfs(i + 1, j, grid, visited);
        
        if(j - 1 >= 0) dfs(i, j - 1, grid, visited);
        if(i - 1 >= 0) dfs(i - 1, j, grid, visited);
    }
    
}