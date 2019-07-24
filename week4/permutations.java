class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, result, new ArrayList<>());
        return result;
    }
    
    public void permutations(int[] nums, List<List<Integer>> result, List<Integer> permutation){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(permutation.contains(nums[i])) continue ;
                permutation.add(nums[i]);
                permutations(nums, result, permutation);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}