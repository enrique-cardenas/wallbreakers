class Solution {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.setAll(parent, i -> i);
        
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[i].length; j++){
                if(M[i][j] == 1){
                    union(i, j, parent);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < parent.length; i++){
            find(i, parent); // path compression
            set.add(parent[i]);
        }
        return set.size();
    }
    
    public int find(int x, int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    
    public void union(int x, int y, int[] parent){
        int x_root = find(x, parent);
        int y_root = find(y, parent);
        parent[x_root] = y_root;
    }
}