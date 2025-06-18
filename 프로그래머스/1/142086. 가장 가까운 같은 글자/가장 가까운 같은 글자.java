import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String,Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++){
            String c = String.valueOf(chars[i]);
            Integer idx = map.get(c);
            if(idx == null){
                answer[i] = -1;
            }else{
                answer[i] = i - idx;
            }
            map.put(c, i);
        }
        
        return answer;
    }
}