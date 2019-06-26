class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        if(!isFirstCapital){
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;    
            }
            return true;
        }
        else{
            // check if all is capital or all lower case after first char
            boolean allCapital = true;
            boolean onlyFirst = true;
            for(int i = 1; i < word.length(); i++){
                if(Character.isLowerCase(word.charAt(i))){
                    allCapital = false;
                }
                else{
                    onlyFirst = false;
                }
            }
            return allCapital || onlyFirst;
        }
        
    }
}