/*

*/
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        long[][] info = new long[diffs.length][3]; // 0 : diff,1 : currentTime , 2:prevTime + time
        
        for(int i = 0; i < diffs.length; i++){
            info[i][0] = (long) diffs[i];
            info[i][1] = (long) times[i];
            info[i][2] = (i == 0) ? 0L : (long) (times[i] + times[i-1]); // diff multiple fator;
        }
        
        Arrays.sort(info, (arr1, arr2) -> Long.compare(arr1[0], arr2[0]));
        
        long low = 1;
        long high = info[info.length - 1][0];
        
        while(low <= high){
            long mid = (low + high) / 2;
            
            if(getTime(info, mid) <= limit){
                if(getTime(info, mid - 1) > limit){
                    return (int) mid;
                }else{
                    high = mid -1;
                }
            }else{
                low = mid + 1;
            }
            
        }
        
        return 1;
        
    }
    
    long getTime(long[][] info, long level){
        long time = 0L;
        for(int i = 0; i < info.length; i++){
            long diff = info[i][0];
            long mainTime = info[i][1];
            long timeFactor = info[i][2];
            
            time += mainTime;
            time += (diff - level > 0) ? (diff - level) * timeFactor : 0;
        }
        return time;
    }
}