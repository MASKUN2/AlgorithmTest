class Solution {
    public int solution(int a, int d, boolean[] included) {
        int length = included.length;
        
        int answer = 0;
        for(int i = 0; i < length; i++){
            if(included[i]){
               answer += a + d*i;
            }
        }
        
        
        return answer;
    }
}