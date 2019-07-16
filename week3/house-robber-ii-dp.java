class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] firstCache = new int[nums.length + 2];
        
        int len = nums.length - 2;
        int firstIndex = 0;
        for(int i = len; i >= 0; i--){
            firstCache[i] = Math.max(nums[i] + firstCache[i + 2], firstCache[i + 1]);
            firstIndex = i;
        }
        
        int[] secondCache = new int[nums.length + 2];
        
        len = nums.length - 1;
        int secondIndex = 0;
        for(int i = len; i >= 1; i--){
            secondCache[i] = Math.max(nums[i] + secondCache[i + 2], secondCache[i + 1]);
            secondIndex = i;
        }
        
        return Math.max(firstCache[firstIndex], secondCache[secondIndex]);
    }
}