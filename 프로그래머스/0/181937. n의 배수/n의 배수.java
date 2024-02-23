class Solution {
    public int solution(int num, int n) {
        int mod = num % n;
        int answer = 0;
        if(mod == 0){
            answer = 1;
        }
        return answer;
    }
}