class Solution {
    public int solution(int a, int b) {
        if(odd(a) && odd(b)){
            return a*a + b*b;
        }
        if(odd(a)||odd(b)){
            return 2*(a+b);
        }
        int tmp = a-b;
        return tmp < 0? -tmp: tmp;
    }
    
    boolean odd(int n){
        return n % 2 == 1;
    }
}