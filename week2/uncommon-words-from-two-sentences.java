class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String a : A.split(" ")){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for(String b : B.split(" ")){
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key) ==  1){
                list.add(key);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}