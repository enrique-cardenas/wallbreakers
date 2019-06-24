class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> sol = new ArrayList<>();
        
        int fizz = 3;
        int buzz = 5;
        
        for(int i = 1; i <= n; i++){
            if(i % fizz == 0 && i % buzz == 0) sol.add("FizzBuzz");
            else if(i % fizz == 0) sol.add("Fizz");
            else if(i % buzz == 0) sol.add("Buzz");
            else sol.add(Integer.toString(i));
        }
        return sol;
    }
}