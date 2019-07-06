class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> sister = new HashSet<>();
        
        for(int i = 0; i < candies.length; i++){
            int candy = candies[i];
            if(!sister.contains(candy) && sister.size() < candies.length / 2){
                sister.add(candy);
            }
        }
        return sister.size();
    }
}