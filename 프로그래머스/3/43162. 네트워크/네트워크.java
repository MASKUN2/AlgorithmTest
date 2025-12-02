import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < computers.length; i++){
            map.put(i, new HashSet<>(Set.of(i)));
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 0 || j > i){
                    continue;
                }
                
                var iSet = map.get(i);
                var jSet = map.get(j);
                
                iSet.addAll(jSet);
                
                for(Integer target : jSet){
                    map.put(target, iSet);
                }
            }
        }
        
        var result = map.values().stream().collect(Collectors.toSet());
        
        return result.size();
        
    }
}