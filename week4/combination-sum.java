class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    public void combinationSum(int[] candidates, int target, List<List<Integer>> result,
                              List<Integer> temp, int start){
        int sum = 0;
        for(int num : temp){
            sum += num;
        }
        if(sum > target) return ;
        if(sum == target){   
            result.add(new ArrayList<>(temp));
            return ;
        }
        
        for(int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            combinationSum(candidates, target, result, temp, i);
            temp.remove(temp.size() - 1);
        }
    }
    
}