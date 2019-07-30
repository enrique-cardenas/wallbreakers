class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            graph[course].add(prereq);
        }
        
        boolean[] beingVisited = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && hasCycle(i, graph, beingVisited, visited)) 
                return false;
        }

        return true;
    }
    
    
    
    public boolean hasCycle(int course, List<Integer>[] graph, boolean[] beingVisited, 
                            boolean[] visited){
        
        beingVisited[course] = true;
        
        for(int prereq: graph[course]){
            if(beingVisited[prereq]) return true;
            if(!beingVisited[prereq] && hasCycle(prereq, graph, beingVisited, visited))
                return true;
        }
        
        beingVisited[course] = false;
        visited[course] = true;
        return false;
    }
}