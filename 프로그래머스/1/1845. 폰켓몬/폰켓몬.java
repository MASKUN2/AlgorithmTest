import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int chance = nums.length / 2;
        
        Set<Integer> pocketmonSet = new HashSet<>();
        for(int i : nums){
            pocketmonSet.add(i);
        }
        
        int pkmTypeOfNumber = pocketmonSet.size();
        
        int answer = Math.min(chance, pkmTypeOfNumber);
        return answer;
    }
}