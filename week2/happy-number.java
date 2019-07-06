class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }
    
    public boolean isHappy(int n, Set<Integer> set){
        if(n == 1) return true;
        
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            digit *= digit;
            sum += digit;
            n /= 10;
        }
        if(set.contains(sum)) return false;
        set.add(sum);
        
        return isHappy(sum, set);
    }
}