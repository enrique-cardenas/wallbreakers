class Solution {
    public int[] plusOne(int[] digits) {
        int endIndex = digits.length - 1;
        if(digits[endIndex] == 9){
            boolean carry = true;
            digits[endIndex] = 0;
            for(int i = endIndex - 1; i >= 0; i--){
                if(carry){
                    if(digits[i] == 9){
                        digits[i] = 0;
                        carry = true;
                    }
                    else{
                        digits[i]++;
                        carry = false;
                    }
                }
                else break;
            }
            if(carry){
                int[] sol = new int[digits.length + 1];
                sol[0] = 1;
                for(int i = 0; i < digits.length; i++){
                    sol[i + 1] = digits[i];
                }
                return sol;
            }

            return digits;
        }
        else digits[digits.length - 1]++;
        return digits;
    }
}