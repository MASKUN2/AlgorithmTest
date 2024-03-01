class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if(ineq.equals(">")){
            if(eq.equals("=")){
                return n >= m? 1 : 0;
            }
            return n > m? 1 : 0;
               
        }
        if(eq.equals("=")){
                return n <= m? 1 : 0;
            }
            return n < m? 1 : 0;
    }
}