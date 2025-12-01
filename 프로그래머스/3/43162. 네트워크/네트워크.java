import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Map<Integer,Computer> map = new HashMap<>();
        List<Computer> list = new ArrayList<>();
        
        for(int i = 0; i < computers[0].length; i++){
            var com = new Computer();
            map.put(i, com);
            list.add(com);
        }
            
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 0){
                    continue;
                }
                // connection
                var iCom = map.get(i);
                var jCom = map.get(j);
                iCom.wind(jCom);
            }
        }
        
        int count = 0;
        
        while(!list.isEmpty()){
            var com = list.get(0);
            list.removeAll(com.network);
            count ++;
        }
        
        return count;
        
    }
    
    class Computer{
        Set<Computer> network = new HashSet<>();
        
        Computer(){
            this.network.add(this);
        }
        
        void wind(Computer com){
            network.addAll(com.network);
            com.network = this.network;
            
            com.network.forEach(c -> c.network = this.network);
        }
    }
}