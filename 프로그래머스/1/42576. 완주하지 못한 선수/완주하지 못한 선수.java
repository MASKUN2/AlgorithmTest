import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> pMap = new HashMap<>();
        for(String name : participant){
            Integer count = pMap.get(name);
            if(count == null){
                pMap.put(name, 1);
            }else{
                pMap.put(name, count+1);
            }
        }
        
        for(String name : completion){
            Integer count = pMap.get(name);
            if(count == null){
                continue;
            }
            if(count > 1){
                pMap.put(name, count -1);
            }else{
                pMap.remove(name);
            }
        }
        
        String answer = (pMap.keySet().toArray(new String[1]))[0];
        return answer;
    }
}