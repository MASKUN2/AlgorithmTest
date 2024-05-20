import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i < players.length;i++){
            map.put(players[i],i);
        }
        for(String str:callings){
            int idx = map.get(str);
             map.put(players[idx-1],idx);
            map.put(str,idx-1);
            String temp = players[idx-1];
            players[idx-1] = str;
            players[idx] = temp;
        }
        
        String[] answer = players;
        return answer;
    }
}