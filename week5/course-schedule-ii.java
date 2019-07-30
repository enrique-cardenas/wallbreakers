class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Khan's Algorithm for Topological Sorting
        
        // graph of courses holding all courses they are prereqs to
        List<Integer>[] prereqGraph = new ArrayList[numCourses];
        for(int i = 0; i < prereqGraph.length; i++){
            prereqGraph[i] = new ArrayList<>();
        }
        
        // indegree of courses
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            
            prereqGraph[prereq].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        
        int[] answer = new int[numCourses];
        int index = 0;
        int size = 0;
        while(!q.isEmpty()){
            int cur = q.remove();
            answer[index] = cur;
            for(int course : prereqGraph[cur]){
                indegree[course]--;
                if(indegree[course] == 0) q.add(course);
            }
            index++;
            size++;
        }
        if(size != numCourses) return new int[0];
        
        return answer;
    }
}