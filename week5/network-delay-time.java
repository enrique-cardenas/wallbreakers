class Solution {
    
    class Node{
        int id;
        // distance from source node
        int distance = Integer.MAX_VALUE;
        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public Node(int id){
            this.id = id;
        }   
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        
        // Dijkstra's Algorithm
        
        Map<Integer, Node> nodes = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            nodes.put(i, new Node(i));
        }
        
        for(int i = 0; i < times.length; i++){
            int nodeKey= times[i][0];
            int targetNodeKey = times[i][1];
            int w = times[i][2];
            
            Node n = nodes.get(nodeKey);
            Node adj = nodes.get(targetNodeKey);
            n.adjacentNodes.put(adj, w);
        }
        
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        
        Node source = nodes.get(K);
        source.distance = 0;
        unsettledNodes.add(source);
        
        
        // start at source node to determine shortest time it takes for source to reach each node
        while(!unsettledNodes.isEmpty()){
            
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            
            for(Map.Entry<Node, Integer> adjPair: currentNode.adjacentNodes.entrySet()){
                Node adjNode = adjPair.getKey();
                Integer w = adjPair.getValue();
                
                if(!settledNodes.contains(adjNode)){
                    calculateMinDistance(adjNode, w, currentNode);
                    unsettledNodes.add(adjNode);
                }
            }
            settledNodes.add(currentNode);
        }
        
        
        // find node with longest time it takes to reach
        // if a node contains max int val as distance, return -1 as it is unreachable from source
        int longest = 0;
        for(int nodeId : nodes.keySet()){
            Node currentNode = nodes.get(nodeId);
            if(currentNode.distance == Integer.MAX_VALUE) return -1;
            if(currentNode.distance > longest) longest = currentNode.distance;
        }
        
        return longest;
    }
    
    public Node getLowestDistanceNode(Set<Node> unsettledNodes){
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for(Node node: unsettledNodes){
            int nodeDistance = node.distance;
            if(nodeDistance < lowestDistance){
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    
    public void calculateMinDistance(Node evalNode, Integer distance, Node sourceNode){
        Integer sourceDistance = sourceNode.distance;
        if(sourceDistance + distance < evalNode.distance){
            evalNode.distance = sourceDistance + distance;
        }
    }
}