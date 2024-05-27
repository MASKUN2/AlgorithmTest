import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> intList = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        intList.add(
            intList.get(intList.size()-1) > intList.get(intList.size() - 2)? 
            intList.get(intList.size()-1) - intList.get(intList.size()-2) : 
            intList.get(intList.size()-1)*2
        );
        int[] answer = intList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return answer;
    }
}