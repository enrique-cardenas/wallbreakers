class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        boolean[] assigned = new boolean[g.length];
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < g.length; j++){
                if(s[i] >= g[j] && !assigned[j]){
                    count++;
                    assigned[j] = true;
                    break;
                }
            }
        }
        return count;
    }
}