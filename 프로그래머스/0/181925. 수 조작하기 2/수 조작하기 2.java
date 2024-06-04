class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i = 0; i < numLog.length; i++){
            int before = 0;
            if(i == 0){
                before = 0;
            }else{
                before = numLog[i-1];
            }
            int diff = numLog[i] - before;
            answer += switch(diff){
                    case 1 -> "w";
                    case -1 -> "s";
                    case 10 -> "d";
                    case -10 -> "a";
                    default -> "";
            };
        }
        return answer;
    }
}