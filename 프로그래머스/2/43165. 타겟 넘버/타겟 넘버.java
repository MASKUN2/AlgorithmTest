import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Num first = null;
        Num last = null;
        
        for(int i = 0; i < numbers.length ; i++){
            int value = numbers[i];
            Num num = new Num(value);
            
            if(first == null){
                first = num;
            }
            if(last != null){
                last.next = num;
            }
            last = num;
        }
        
        return first.countWayMake(target);
    }
    
    class Num{
        final int value;
        Num next;
        
        Num(int value){
            this.value = value;
        }
        
        int countWayMake(int target){
            
            return countWayMakeRecursive(target, 0);
        }
        
        private int countWayMakeRecursive(int target, int result){
            int count = 0;
            
            int plusResult = result + this.value;
            int minusResult = result - this.value;
            
            if(next != null){
                count += next.countWayMakeRecursive(target, plusResult);
                count += next.countWayMakeRecursive(target, minusResult);
                return count;
            }
            
            //next is null
            if(plusResult == target || minusResult == target){
                return 1;
            }
            
            return 0;
        }
    }
    
}