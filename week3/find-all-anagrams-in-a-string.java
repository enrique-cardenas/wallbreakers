class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> answer = new ArrayList<>();
        
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        
        char[] currentChars = new char[p.length()];
        
        for(int i = 0; i < s.length(); i++){
            
            // fill currentChars until length of pChars
            if(i < p.length()){
                currentChars[i] = s.charAt(i);
            }
            else{
                // after currentChars is pChars length
                // insert the char at index i in appropriate index
                char c = s.charAt(i);
                for(int j = currentChars.length - 1; j >= 0; j--){
                    if(currentChars[j] == '-'){
                        currentChars[j] = c;
                    }
                    
                    else if(currentChars[j] > currentChars[j + 1]){
                        char temp = currentChars[j];
                        currentChars[j] = currentChars[j + 1];
                        currentChars[j + 1] = temp;
                    }
                    else{
                        break;
                    }
                }
            }
            
            if(i == p.length() - 1){
                Arrays.sort(currentChars);
            }
            
            if(i >= p.length() - 1){
                if(Arrays.equals(currentChars, pChars)){
                    answer.add(i - p.length() + 1);
                }
                // remove char at i - p.length() + 1 index
                int removeIndex = i - p.length() + 1;
                char c = s.charAt(removeIndex);
                
                // find index of char and replace with -
                int cIndex = Arrays.binarySearch(currentChars, c);
                currentChars[cIndex] = '-';
                
                // shift array chars from where the char was removed
                for(int j = cIndex; j < currentChars.length - 1; j++){
                    char temp = currentChars[j];
                    currentChars[j] = currentChars[j + 1];
                    currentChars[j+1] = temp;
                }   
            }
        }
        return answer;
    }
}