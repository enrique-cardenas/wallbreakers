class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>(); // num -> index
        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            int op = target - current;
            if(map.containsKey(op)){
                return new int[] {map.get(op), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}