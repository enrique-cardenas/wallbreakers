class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        // check if sum can be partitioned to equal subsets
        if(sum % 2 != 0) return false;
        System.out.println(sum);
        Arrays.sort(nums);
        if(nums[nums.length - 1] > sum / 2) return false;
        return canPartition(nums, sum, nums.length - 1, 0);
    }
    
    public boolean canPartition(int[] nums, int targetSum, int index, int currentSum){
        if(currentSum == targetSum / 2){
            return true;
        }
        if(currentSum > targetSum / 2) return false;
        
        boolean result = false;
        for(int i = index; i >= 0; i--){
            result = canPartition(nums, targetSum, i - 1, currentSum + nums[i]);
            if(result) return result;
        }
        return false;
    }
}