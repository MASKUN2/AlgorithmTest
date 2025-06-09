class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int currNo = 0;
        int coverLimit = 0;
        
        for(int i = 0; i < section.length; i ++){
            if(section[i] > coverLimit) {
                currNo = section[i];
                coverLimit = currNo + (m - 1);
                answer ++;
                continue;
            }
            
        }
        
        return answer;
    }
}