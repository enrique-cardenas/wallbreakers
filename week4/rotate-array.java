class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : nums) q.add(num);
        for(int i = k; i < nums.length + k; i++){
            nums[i % nums.length] = q.remove();
        }
    }
}