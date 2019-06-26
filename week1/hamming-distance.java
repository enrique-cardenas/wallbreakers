class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for(int i = 0; i < 32; i++){
            int bitCheck = xor & 1;
            if(bitCheck == 1){
                count++;
            }
            xor = xor >> 1;
        }
        return count;
    }
}