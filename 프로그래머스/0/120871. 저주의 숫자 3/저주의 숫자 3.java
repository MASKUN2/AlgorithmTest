class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer++;
            while(isCursed(answer)){
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isCursed(int n){
        String text = String.valueOf(n);
        if(text.contains("3")){
            return true;
        }
        
        if(n % 3 == 0){
            return true;
        }
        return false;
    }
}