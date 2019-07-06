class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] answer = new int[2];
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 1; i <= nums.length; i++){
            if(!freqMap.containsKey(i)){
                answer[1] = i;
            }
            if(freqMap.containsKey(i) && freqMap.get(i) > 1){
                answer[0] = i;
            }
        }
        
        return answer;
    }
}