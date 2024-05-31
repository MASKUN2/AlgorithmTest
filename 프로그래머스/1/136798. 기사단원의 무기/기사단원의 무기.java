import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int iron = 0;
        for(int i = 1; i <= number; i++){
            int factorsNum = 0;
            Set<Integer> set = new HashSet<>();
            for(int j = 1; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    set.add(j);
                    set.add(i/j);
                }
            }
            factorsNum = set.size();
            if(factorsNum > limit){
                factorsNum = power;
            }
            iron += factorsNum;
        }
        
        int answer = iron;
        return answer;
    }
}