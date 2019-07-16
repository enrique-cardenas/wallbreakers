class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] cache1 = new int[nums.length];
        for(int i = 0; i < cache1.length; i++){
            cache1[i] = -1;
        }
        
        int[] cache2 = new int[nums.length];
        for(int i = 0; i < cache2.length; i++){
            cache2[i] = -1;
        }
        
        int first = rob(nums, 0, nums.length - 1, cache1);
        int second = rob(nums, 1, nums.length, cache2);
        
        return Math.max(first, second);
    }
    
    public int rob(int[] nums, int currentIndex, int length, int[] cache){
        if(currentIndex >= length) return 0;
        if(cache[currentIndex] >= 0) return cache[currentIndex];
        
        cache[currentIndex] = 
            Math.max(nums[currentIndex] + rob(nums, currentIndex + 2, length, cache), 
                            rob(nums, currentIndex + 1, length, cache));
        return cache[currentIndex];
    }
}