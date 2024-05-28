class Solution {
    public int solution(int n, String control) {
        char[] chars = control.toCharArray();
        for(char c : chars){
            if(c == 'w'){
                n = n + 1;
            }
            if(c == 's'){
                n = n - 1;
            }
            if(c == 'd'){
                n = n + 10;
            }
            if(c == 'a'){
                n = n - 10;
            }
        }
        return n;
    }
}