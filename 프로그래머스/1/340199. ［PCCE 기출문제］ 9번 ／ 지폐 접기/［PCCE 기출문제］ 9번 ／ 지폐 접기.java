class Solution {
    public int solution(int[] wallet, int[] bill) {
        int count = 0;
        boolean flag = true;
        while(flag){
            if(
                (wallet[0] >= bill[0] && wallet[1] >= bill[1])
                || (wallet[0] >= bill[1] && wallet[1] >= bill[0])
            ){
                flag = false;
                break;
            }else{
                if( bill[0] > bill[1] ){
                    bill[0] = bill[0] / 2;
                }else{
                    bill[1] = bill[1] / 2;
                }
                count++;
            }
        }
        return count;
    }
}