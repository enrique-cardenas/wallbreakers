class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        
        // change in prices
        int[] dPrices = new int[prices.length - 1];
        
        for(int i = 1; i < prices.length; i++){
            dPrices[i - 1] = prices[i] - prices[i-1];
        }
        int max = findMaxSubarray(dPrices, 0, dPrices.length - 1);
        return max >= 0 ? max : 0;
    }
    
    public int findMaxCrossingSubarray(int[] A, int low, int mid, int high){
        int leftSum = 0;
        int sum = 0;
        for(int i = mid; i >= low; i--){
            sum += A[i];
            if(sum > leftSum) leftSum = sum;
        }
        
        int rightSum = 0;
        sum = 0;
        for(int i = mid + 1; i <= high; i++){
            sum += A[i];
            if(sum > rightSum) rightSum = sum;
        }
        return leftSum + rightSum;
    }
    
    public int findMaxSubarray(int[] A, int low, int high){
        if(low == high) return A[low];
        else{
            int mid = (low + high) / 2;
            
            return Math.max(Math.max(findMaxSubarray(A, low, mid),
                                     findMaxSubarray(A, mid + 1, high)),
                            findMaxCrossingSubarray(A, low, mid, high));
        }
    }
}