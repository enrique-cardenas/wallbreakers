class Solution {
    public String reverseVowels(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        
        int pt1 = 0;
        int pt2 = s.length() - 1;
        char[] answer = s.toCharArray();
        while(pt1 < pt2){
            if(!isVowel(answer[pt1])){
                pt1++;
            }
            if(!isVowel(answer[pt2])){
                System.out.println(pt2);
                pt2--;
            }
            if(isVowel(answer[pt1]) && isVowel(answer[pt2])){
                char temp = answer[pt1];
                answer[pt1] = answer[pt2];
                answer[pt2] = temp;
                pt1++;
                pt2--;
            }
        }
        return String.valueOf(answer);
    }
    
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}