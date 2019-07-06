class Solution {
    public int numSpecialEquivGroups(String[] A) {
        
        List<List<String>> specialEquivGroups = new ArrayList<>();
        int groupIndex = 0;
        boolean[] isStringGrouped = new boolean[A.length];
        
        for(int i = 0; i < A.length; i++){
            
            if(!isStringGrouped[i]){
                List<String> specialEquivStrings = new ArrayList<>();
                
                Map<Character, Integer> evens = new HashMap<>();
                Map<Character, Integer> odds = new HashMap<>();
                mapChars(evens, odds, A[i]);
                
                specialEquivStrings.add(A[i]);
                
                isStringGrouped[i] = true;


                for(int j = i + 1; j < A.length; j++){
                    Map<Character, Integer> evens_2 = new HashMap<>();
                    Map<Character, Integer> odds_2 = new HashMap<>();

                    mapChars(evens_2, odds_2, A[j]);

                    if(evens.equals(evens_2) && odds.equals(odds_2)){
                        specialEquivStrings.add(A[j]);
                        isStringGrouped[j] = true;
                    }
                }
                
                specialEquivGroups.add(groupIndex, specialEquivStrings);
                groupIndex++;
            }
        }
        return specialEquivGroups.size();
    }
    
    
    public void mapChars(Map<Character, Integer> evens, Map<Character, Integer> odds, String curr){
        
        for(int i = 0; i < curr.length(); i ++){
            char c = curr.charAt(i);
            if(i % 2 == 0){
                evens.put(c, evens.getOrDefault(c, 0) + 1);
            }
            else{
                odds.put(c, odds.getOrDefault(c, 0) + 1);
            }
        }
    }

}