class Solution {
    public int[][] merge(int[][] intervals) {
        
        // sort by start index
        Arrays.sort(intervals, (a, b) ->{
            return a[0] - b[0];
        });
        
        // mark interval with index of interval it overlaps with
        int[] overlapsWith = new int[intervals.length];
        Arrays.fill(overlapsWith, -1);
        
        for(int i = 0; i < intervals.length; i++){
            if(overlapsWith[i] >= 0) continue ;
            overlapsWith[i] = i;

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            
            for(int j = i + 1; j < intervals.length; j++){
                if(overlapsWith[j] >= 0) continue ;
                int nextStart = intervals[j][0];
                int nextEnd = intervals[j][1];
                
                if(nextStart <= currentEnd){
                    overlapsWith[j] = i;
                    
                    currentEnd = nextEnd > currentEnd ? nextEnd : currentEnd;
                }
            }
            intervals[i][1] = currentEnd;
        }
        
        Set<Integer> overlapIndices = new TreeSet<>();
        for(int i = 0; i < overlapsWith.length; i++){
            overlapIndices.add(overlapsWith[i]);
        }
        
        int[][] answer = new int[overlapIndices.size()][2];
        int index = 0;
        for(int key: overlapIndices){
            answer[index] = intervals[key];
            index++;
        }
        
        return answer;
    }
}