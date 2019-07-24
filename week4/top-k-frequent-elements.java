class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = 
            new PriorityQueue<>(k, (a, b) -> freqMap.get(b) - freqMap.get(a));
        for(int num : freqMap.keySet()){
            heap.add(num);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < k; i++){
            answer.add(heap.poll());
        }
        return answer;
    }
}