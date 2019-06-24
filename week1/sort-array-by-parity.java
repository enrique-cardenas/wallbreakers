class Solution {

    public int[] sortArrayByParity(int[] A) {
        int[] evens = new int[A.length];
        int[] odds = new int[A.length];
        
        int evensIndex = 0;
        int oddsIndex = 0;
        
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                evens[evensIndex++] = A[i];
            }
            else{
                odds[oddsIndex++] = A[i];
            }
        }
        
        int[] answer = new int[A.length];
        for(int i = 0; i < evensIndex; i++){
            answer[i] = evens[i];
        }
        for(int i = 0; i < oddsIndex; i++){
            answer[i + evensIndex] = odds[i];
        }
        
        return answer;
    }
}
