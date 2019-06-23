class Solution {
    public int[][] transpose(int[][] A) {
        int[][] answer = new int[A[0].length][A.length];
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                answer[i][j] = A[j][i];
            }
        }
        return answer;
    }
}
