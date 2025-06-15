class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int seq1 = 0;
        int seq2 = 0; 
        for(int i = 0; i < goal.length; i ++){
            String word = goal[i];
            
            String card1Word = seq1 >= cards1.length ? null : cards1[seq1] ;
            String card2Word = seq2 >= cards2.length ? null : cards2[seq2] ;
            
            if(word.equals(card1Word)){
                seq1 ++;
                continue;
            }else if(word.equals(card2Word)){
                seq2 ++;
                continue;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}