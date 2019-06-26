class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        int power = 1;
        for(int i = 1; i <= n / 2; i++){
            power *= 2;
            if(n == power) return true;
        }
        return false;
    }
}