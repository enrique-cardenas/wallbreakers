class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if(totalSum % k != 0) return false;
        
        return canPartition(nums, k, new boolean[nums.length], 0, totalSum / k, 0);
    }
    
    public boolean canPartition(int[] nums, int subsetsLeft, boolean[] used, 
                                int currentSum, int subsetTargetSum, int start){
        
        if(subsetsLeft == 1) return true;
        
        if(currentSum == subsetTargetSum) 
            return canPartition(nums, subsetsLeft - 1, used, 0, subsetTargetSum, 0);
        
        for(int i = start; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                if(canPartition(nums, subsetsLeft, used, currentSum + nums[i], subsetTargetSum,
                                i + 1))
                   return true;
                used[i] = false;
            }
        }
        return false;
    }
}