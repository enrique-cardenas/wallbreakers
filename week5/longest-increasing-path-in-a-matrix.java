class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        
        boolean[][] visiting = new boolean[matrix.length][matrix[0].length];
        
        // cache longest path for each index;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < cache.length; i++){
            Arrays.fill(cache[i], -1);
        }
        
        List<Integer> list = new ArrayList<>();
        int longestPath = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(cache[i][j] == -1){
                    longestPath = Math.max(longestPath, dfs(matrix, i, j, visiting, cache));
                }
                else longestPath = Math.max(longestPath, cache[i][j]);
            }
        }
        return longestPath;
    }
    
    
    public int dfs(int[][] matrix, int i, int j, boolean[][] visiting, int[][] cache){
        
        if(cache[i][j] == -1){
        
            visiting[i][j] = true;
            int cur = matrix[i][j];
            int longestPath = 0;

            if(j > 0 && matrix[i][j-1] > cur && !visiting[i][j-1])
                longestPath = Math.max(longestPath, dfs(matrix, i, j-1, visiting, cache));

            if(j < matrix[i].length - 1 && matrix[i][j+1] > cur && !visiting[i][j+1])
                longestPath = Math.max(longestPath, dfs(matrix, i, j+1, visiting, cache));

            if(i > 0 && matrix[i-1][j] > cur && !visiting[i-1][j])
                longestPath = Math.max(longestPath, dfs(matrix, i-1, j, visiting, cache));

            if(i < matrix.length - 1 && matrix[i+1][j] > cur && !visiting[i+1][j])
                longestPath = Math.max(longestPath, dfs(matrix, i+1, j, visiting, cache));

            visiting[i][j] = false;
            cache[i][j] = longestPath + 1;

            return longestPath + 1;
        }
        
        return cache[i][j];
    }
}