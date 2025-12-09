import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int[][] dp = new int[info.length][m]; // dp[물건idx][b도둑 누적흔적] = a도둑 누적흔적
        
        for(int i = 0; i < info.length; i++){
            Arrays.fill(dp[i], n + 1);
        }
        
        for(int i = 0; i < info.length; i++){
            //0번째
            if(i == 0){
                dp[0][0] = info[0][0]; // a가 훔침
                
                if(info[0][1] < m){ // 0번째 b 흔적이 m보다 작을때만 b가 훔침
                    dp[0][info[0][1]] = 0;
                }
                continue;
            }
            
            //i번째
            for(int b = 0; b < m; b++){
                int prevA = dp[i-1][b];
                if(prevA >= n) continue;
                
                //a가 훔치는 경우 갱신
                int newA = prevA + info[i][0];
                // 초기값 (n + 1) 또는 이전 newB의 루프에서 갱신한 a 흔적보다 작은 경우에만 갱신
                dp[i][b] = Math.min(dp[i][b], newA); 
                
                //b가 훔치는 경우 갱신
                int newB = b + info[i][1];
                if(newB >= m) continue;
                dp[i][newB] = Math.min(prevA, dp[i][newB]);
            }
        }
        
        int minA = -1;
        for(int b = 0; b < m; b++){
            int a = dp[info.length -1][b];
            if(a >= n){
                continue;
            }
            if(minA == -1){
                minA = a;
                continue;
            }
            minA = Math.min(minA, a);
        }    
        return minA;
    }
}