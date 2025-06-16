import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todays = days(today);
        Map<String,Integer> termMap = Arrays.stream(terms)
            .collect(Collectors.toMap(s -> s.split(" ")[0], s -> Integer.valueOf(s.split(" ")[1]) * 28 ));
        
        List<Integer> expired = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i ++){
            String[] privacy = privacies[i].split(" ");
            int expiring = days(privacy[0]) + termMap.get(privacy[1]);
            if(todays >= expiring){
                expired.add(i+1);
            }
        }
        int[] answer = new int[expired.size()];
        for (int i = 0; i < expired.size(); i++) {
            answer[i] = expired.get(i); 
        }
        return answer;
    }
    
    int days(String s){
        String[] array = s.split("\\.");
        return Integer.valueOf(array[0]) * 12 * 28
            + Integer.valueOf(array[1]) * 28
            + Integer.valueOf(array[2]);
    }
}