class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] color = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            // graph may be disconnected so traverse all unvisited nodes
            if(!visited[i]){
                color[i] = 1;
                if(!dfs(i, graph, color, visited)) return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int cur, int[][] graph, int[] color, boolean[] visited){
        
        for(int i = 0; i < graph[cur].length; i++){
            int adj = graph[cur][i];
            if(!visited[adj]){
                visited[adj] = true;
                color[adj] = -color[cur];
                if(!dfs(adj, graph, color, visited)) return false;
            }
            else{
                // adjacent vertices cannot have the same color for graph to be bipartite
                if(color[adj] == color[cur]) return false;
            }
        }
        return true;
    }
}