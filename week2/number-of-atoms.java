class Solution {
    public String countOfAtoms(String formula) {
        
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new TreeMap());
        
        int len = formula.length();
        for(int i = 0; i < len; i++){
            char cur = formula.charAt(i);

            if(cur == ')'){
                // get the topmost map of the stack and multiply all element counts by the
                // following number
                Map<String, Integer> currentMap = stack.pop();
                
                int start = ++i;
                while(i < len && Character.isDigit(formula.charAt(i))) i++;
                
                int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                for(String elementName: currentMap.keySet()){
                    currentMap.put(elementName, currentMap.getOrDefault(elementName, 0) * count);
                }
                
                
                // get the next topmost map of the stack and add the previous map's element
                // and element counts to it
                Map<String, Integer> botMap = stack.pop();
                for(String element: currentMap.keySet()){
                    botMap.put(element, botMap.getOrDefault(element, 0) + currentMap.get(element));
                }
                
                stack.push(botMap);
                i--;
                continue;
            }
            
            if(cur == '('){
                stack.push(new TreeMap());
                continue;
            }
            
            // get element name
            int start = i++;
            while(i < len && Character.isLowerCase(formula.charAt(i))) i++;
            String elementName = formula.substring(start, i);

            // get element count
            start = i;
            while(i < len && Character.isDigit(formula.charAt(i))) i++;
            int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));

            // put element with count onto the topmost map of the stack
            Map<String, Integer> currentMap = stack.pop();
            currentMap.put(elementName, currentMap.getOrDefault(elementName, 0) + count);

            stack.push(currentMap);
            i--;
        }
        
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = stack.pop();
        for(Map.Entry<String, Integer> element: map.entrySet()){
            answer.append(element.getKey());
            int count = element.getValue();
            if(count > 1) answer.append(String.valueOf(count));
        }
        
        return answer.toString();
    }
}