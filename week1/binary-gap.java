class Solution {
    public int binaryGap(int N) {
        int max = 0;
        int count = 0;
        boolean inGap = false;
        for(int i = 0; i < 32; i++){
            int bitCheck = N & 1;
            
            if(bitCheck == 1){
                if(inGap){
                    if(count > max) max = count;
                    count = 0;
                }
                inGap = true;
            }
            
            if(inGap){
                count++;
            }
            N >>= 1;
        }
        return max;
    }
}