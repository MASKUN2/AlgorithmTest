import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> nameYearn = new HashMap<>();
        for(int i = 0; i < name.length; i ++){
            nameYearn.put(name[i], yearning[i]);
        }
        int[] answer = Arrays.stream(photo).mapToInt(strs -> Arrays.stream(strs).map(s->nameYearn.get(s) == null? 0 : nameYearn.get(s)).reduce(0, (a,b)->a+b)).toArray();
        return answer;
    }
}