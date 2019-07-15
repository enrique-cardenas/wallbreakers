class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        
        List<List<Integer>> groups = new ArrayList<>();
        
        boolean[] inGroup = new boolean[points.length];
        
        for(int i = 0; i < points.length; i++){
            if(inGroup[i]) continue ;
            inGroup[i] = true;
            int currentStart = points[i][0];
            int currentEnd = points[i][1];
            
            List<Integer> currentGroup = new ArrayList<>();
            currentGroup.add(i);
            
            for(int j = i + 1; j < points.length; j++){
                if(inGroup[j]) continue ;
                
                int start = points[j][0];
                int end = points[j][1];
                
                if((start >= currentStart && start <= currentEnd) ||
                    (end >= currentStart && end <= currentEnd)){
                    currentGroup.add(j);
                    inGroup[j] = true;
                    
                    if(start > currentStart) currentStart = start;
                    if(end < currentEnd) currentEnd = end;
                }
            }
            groups.add(currentGroup);
        }
        return groups.size();
    }
}