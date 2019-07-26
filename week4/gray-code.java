class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0) return result;
        grayCode(result, n);
        return result;
    }
    
    public void grayCode(List<Integer> result, int n){
        if(result.size() == Math.pow(2,n)){
            return ;
        }
        for(int i = 0; i < n; i++){
            int num = result.get(result.size() - 1) ^ (1 << i);
            if(result.contains(num)) continue ;
            result.add(num);
            grayCode(result, n);
        }
    }
}