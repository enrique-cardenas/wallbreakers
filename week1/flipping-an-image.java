class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] answer = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                answer[i][j] = A[i][A[i].length - j - 1];
                if(answer[i][j] == 1) answer[i][j] = 0;
                else answer[i][j] = 1;
            }
        }
        return answer;
    }
}