class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(result, new ArrayList<>(), n, k, 1);
        return result;
    }
    
    public void combinations(List<List<Integer>> result, List<Integer> combination, 
                             int n, int k, int start){
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
        }
        else{
            for(int i = start; i <= n; i++){
                if(combination.contains(i)) continue ;
                combination.add(i);
                combinations(result, combination, n, k, i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}