class Solution {
    public int findComplement(int num) {
        // find leftmost one
        int copy = num;
        int ones = 1;
        for(int i = 0; i < 32; i++){
            copy = copy >> 1;
            if(copy <= 0){
                break;
            }
            else{
                ones = ones << 1;
                ones++;
            }
        }
        // xoring the num with all ones will flip the bits 
        return num ^ ones;
    }
}