class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        int nMod = number % n;
        int mMod = number % m;
        if(nMod == 0 && mMod == 0){
            answer = 1;
        }
        return answer;
    }
}