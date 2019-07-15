class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndices = new int[26];
        
        for(int i = 0; i < S.length(); i++){
            lastIndices[S.charAt(i) - 'a'] = i;
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int startIndex = 0;
        int lastIndexSeen = 0;
        for(int i = 0;  i < S.length(); i++){
            
            int currentLast = lastIndices[S.charAt(i) - 'a'] ;
            if(currentLast > lastIndexSeen) lastIndexSeen = currentLast;
            if(i == lastIndexSeen){
                int partitionSize = i - startIndex + 1;
                answer.add(partitionSize);
                startIndex = i + 1;
            }
        }
        return answer;
    }
}