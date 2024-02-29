class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n % 2 == 1){
            for(int i = n; i > 0; i--){
                if(i % 2 == 0){
                    continue;
                }
                answer += i;
            }
            return answer;
        }
        for(int i = n; i > 0; i--){
                if(i % 2 == 1){
                    continue;
                }
                answer += (i*i);
            }
        
        
        return answer;
    }
}