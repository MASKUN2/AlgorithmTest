import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int targetX = maps.length - 1;
        int targetY = maps[0].length - 1;
        
        var visited = new boolean[maps.length][maps[0].length];
        
        var queue = new LinkedList<int[]>();
        queue.offer(new int[] {0,0,1});
        
        var directions = new int[][]{{0, 1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            var current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            if(x == targetX && y == targetY){
                return count;
            }
            
            for(var direction : directions){
                int newX = x + direction[0];
                int newY = y + direction[1];
                
                if(newX >= maps.length || newX < 0){
                    continue;
                }
                
                if(newY >= maps[0].length || newY < 0){
                    continue;
                }
                
                if(visited[newX][newY]){
                    continue;
                }
                     
                visited[newX][newY] = true;
                
                if(maps[newX][newY] == 0){
                    continue;
                }
                
                queue.offer(new int[] {newX,newY,count + 1});
            }
            
        }
        return -1;
    }
}