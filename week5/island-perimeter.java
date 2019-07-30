class Solution {
    public int islandPerimeter(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int perimeter = 0;
        
        boolean found = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    perimeter = dfs(grid, i, j, 0, visited);
                    found = true;
                }
                if(found) break;
            }
            if(found) break;
        }
        
        return perimeter;
    }
    
    public int dfs(int[][] grid, int i, int j, int perimeter, boolean[][] visited){
        
        visited[i][j] = true;
        
        if(j == 0 || grid[i][j-1] == 0) perimeter++;
        if(j == grid[i].length-1 || grid[i][j+1] == 0) perimeter++;
        if(i == 0 || grid[i-1][j] == 0) perimeter++;
        if(i == grid.length-1 || grid[i+1][j] == 0) perimeter++;
        
        if(j > 0 && grid[i][j - 1] == 1 && !visited[i][j-1]) 
            perimeter += dfs(grid, i, j-1, 0, visited);
            
        if(j < grid[i].length-1 && grid[i][j + 1] == 1 && !visited[i][j+1]) 
            perimeter += dfs(grid, i, j+1, 0, visited);
        
        if(i > 0 && grid[i - 1][j] == 1 && !visited[i-1][j])
            perimeter += dfs(grid, i-1, j, 0, visited);
        
        if(i < grid.length - 1 && grid[i + 1][j] == 1 && !visited[i+1][j])
            perimeter += dfs(grid, i+1, j, 0, visited);
        
        
        return perimeter;
    }
    
}