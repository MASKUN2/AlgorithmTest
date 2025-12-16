import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        List<int[]> candidates = new ArrayList<>();
        boolean end = false;
        while(!end){
            if(sum == k){
                candidates.add(new int[] {left, right});
                if(right == sequence.length - 1){
                    break;
                }
                sum += sequence[++right];
                continue;
            }
            if(sum > k){
                if(left == right){
                    break;
                }
                sum -= sequence[left++];
                continue;
            }
            if(sum < k){
                if(right == sequence.length - 1){
                    break;
                }
                sum += sequence[++right];
                continue;
            }
        }
        candidates.sort((arr1, arr2) -> (arr1[1] - arr1[0]) - (arr2[1] - arr2[0]));
        
        return candidates.get(0);
    }
}