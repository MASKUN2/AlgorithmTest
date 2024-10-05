import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> preNumbers = new HashSet<>();
        Set<String> numbers = new HashSet<>();
        for(String n : phone_book){
            if(preNumbers.contains(n)){
                return false;
            }
            for(int i = 0; i < n.length(); i++){
                String pre = n.substring(0,i);
                if(numbers.contains(pre)){
                    return false;
                }
                preNumbers.add(pre);
            }
            numbers.add(n);
        }
        
        boolean answer = true;
        return answer;
    }
}