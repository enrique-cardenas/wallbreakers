class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int currentMax = 0;
        
        for(int i = 1; i < prices.length; i++){
            currentMax += prices[i] - prices[i - 1];
            if(currentMax > max) max = currentMax;
            if(currentMax < 0) currentMax = 0;
        }
        return max;
    }
}