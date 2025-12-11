import java.util.*;

class Solution {
    static int length;
    static int depth;
    static int[][] land;
    static int[] discovery;
    static int[][] directions = new int[][] {{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int solution(int[][] l) {
        length = l[0].length;
        depth = l.length;
        land = l;
        discovery = new int[length];
        
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < length; j++){
                if(land[i][j] == 1){
                    explore(i, j);
                }
            }
        }
        
        Arrays.sort(discovery);
        return discovery[length - 1];
    }
    
    void explore(int depth, int position){
        
        Aggregator aggregator = new Aggregator();
        extract(depth, position, aggregator);
        
        for(int i = aggregator.minPosition; i <= aggregator.maxPosition; i++){
            discovery[i] += aggregator.volume;
        }
    }
    
    static class Aggregator{
        int volume = 0;
        int minPosition = Integer.MAX_VALUE;
        int maxPosition = 0;
        
        void updatePosition(int p){
            minPosition = Math.min(minPosition, p);
            maxPosition = Math.max(maxPosition, p);
        }
    }
    
    void extract(int depth, int position, Aggregator aggregator){
        if(land[depth][position] != 1) return;
        land[depth][position] = 0;
        aggregator.volume++;
        aggregator.updatePosition(position);
        
        for(int[] direction : directions){
            int newDepth = depth + direction[0];
            int newPosition = position + direction[1];
            
            if(newDepth < 0 || newDepth >= this.depth 
               || newPosition < 0 || newPosition >= this.length 
               || land[newDepth][newPosition] == 0){
                continue;
            }
            extract(newDepth , newPosition, aggregator);
        }
    }
    
}