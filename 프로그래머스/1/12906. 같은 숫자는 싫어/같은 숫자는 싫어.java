import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i : arr){
            if(list.size() > 0){
                int idx = list.size()-1;
                if(list.get(idx) == Integer.valueOf(i)){
                    continue;
                }
            }
            list.add(i);
        }
        
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}