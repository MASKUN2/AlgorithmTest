import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int product = Arrays.stream(num_list).reduce((a,b)-> a*b).getAsInt();
        int sum = Arrays.stream(num_list).reduce((a,b)-> a+b).getAsInt();
        int answer = product > sum*sum? 0:1;
        return answer;
    }
}