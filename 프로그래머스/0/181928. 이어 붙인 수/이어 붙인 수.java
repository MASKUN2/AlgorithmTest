import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int oddConcat = Arrays.stream(num_list)
            .filter(a -> a % 2 == 1)
            .mapToObj(String::valueOf)
            .reduce((a, b) -> a+b)
            .map(Integer::valueOf)
            .orElse(0);
         int evenConcat = Arrays.stream(num_list)
            .filter(a -> a % 2 == 0)
            .mapToObj(String::valueOf)
            .reduce((a, b) -> a+b)
            .map(Integer::valueOf)
            .orElse(0);
        
        int answer = oddConcat + evenConcat;
        return answer;
    }
}