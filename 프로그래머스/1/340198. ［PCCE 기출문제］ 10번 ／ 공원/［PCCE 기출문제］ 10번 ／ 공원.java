class Solution {
    public int solution(int[] mats, String[][] park) {
        int maxEmpty = 0;
        
        for(int i = 0; i < park.length ; i ++){
            for(int j = 0; j < park[i].length ; j ++){
                if( ! park[i][j].equals("-1")){
                  continue;  
                }
                maxEmpty = Math.max(maxEmpty, 1);
                for(int empty = 1; (i + empty) < park.length && (j + empty) < park[i].length ; empty ++ ){
                    boolean clear = true;
                    if(! park[i+empty][j+empty].equals("-1")){
                        break;
                    }
                    for (int k = 0; k <= empty; k++) {
                        if (!park[i + empty][j + k].equals("-1") || !park[i + k][j + empty].equals("-1")) {
                            clear = false;
                            break;
                        }
                    }
                    if(!clear){
                        break;
                    }
                    maxEmpty = Math.max(maxEmpty, empty + 1);
                }
            }
        }
        int answer = -1;
        for(int i = 0; i < mats.length; i ++){
            if(maxEmpty >= mats[i] && mats[i] > answer){
                answer = mats[i];
            }
        }
        
        
        return answer;
    }
}