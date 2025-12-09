class Solution {
    public int solution(int[] players, int m, int k) {
        int[][] dp = new int[players.length][3]; // [24][0: 플레이어 수, 1:증설서버 수, 2: 증설횟수]
        int answer = 0;
        
        for(int i = 0; i < players.length; i++){
            dp[i][0] = players[i];
            
            int playerCount = dp[i][0];
            int requiredServerCount = playerCount / m ; 
            int serverCount = dp[i][1]; // 처음엔 0
            
            if(requiredServerCount <= serverCount) {
                continue;
            }
            
            int scaleOutCount = requiredServerCount - serverCount;
            
            dp[i][2] = scaleOutCount;
            answer += scaleOutCount;
            
            
            for(int j = 0; j < k && j + i < players.length; j++){
                dp[i + j][1] = dp[i + j][1] + scaleOutCount;
            }
            
        }
        
        return answer;
    }
}