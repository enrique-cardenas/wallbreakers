class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        subsets(nums, answer, new ArrayList<Integer>(), 0);
        return answer;
    }
    
    public void subsets(int[] nums, List<List<Integer>> result, List<Integer> sub, int start){
        result.add(new ArrayList<>(sub));
        for(int i = start; i <  nums.length; i++){
            sub.add(nums[i]);
            subsets(nums, result, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
