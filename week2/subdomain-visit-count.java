class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> visitMap = new HashMap<>();
        
        for(String curr: cpdomains){
            
            String[] countPair = curr.split(" ");
            String[] domains = countPair[1].split("\\.");
            
            int count = Integer.valueOf(countPair[0]);
            
            String fullDomain = countPair[1];
            visitMap.put(fullDomain, visitMap.getOrDefault(fullDomain, 0) + count);
            
            String topDomain = domains[domains.length - 1];
            visitMap.put(topDomain, visitMap.getOrDefault(topDomain, 0) + count);
                
            if(domains.length == 3){
                String nextTopDomain = domains[1] + "." + domains[2];
                visitMap.put(nextTopDomain, visitMap.getOrDefault(nextTopDomain, 0) + count);   
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(String key: visitMap.keySet()){
            answer.add(visitMap.get(key) + " " + key);
        }
        return answer;
    }
}
