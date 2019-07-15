class Solution {
    
    
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return 1;
        if(x == -1) return n % 2 == 0 ? 1 : -1;

        // if x is a decimal and n == int max val
        if(-1 < x && x < 1 && n == Integer.MAX_VALUE) return 0;
        
        // if n is negative and lowest int value
        if(n == Integer.MIN_VALUE){
            n = Integer.MAX_VALUE;
            return myPow(1/x, n);
        }
           
        
        // if n is negative
        if(n < 0) return myPow(1/x, -n);
        
        // store solutions in array
        double[] dp = new double[n + 1];
        dp[0] = 1;
        dp[1] = x;
        
        return myPow(x, n, dp); 
    }
    
    public double myPow(double x, int n, double[] dp) {
        if(n == 0) return dp[0];
        if(n == 1) return dp[1];
        
        if(n % 2 == 0){
            dp[n] = myPow(x, n / 2, dp) * myPow(x, n / 2, dp);
        }
        else{
            dp[n] = x * myPow(x, n / 2, dp) * myPow(x, n / 2, dp);
        }
        
        return dp[n];
    }
}