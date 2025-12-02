import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //rectangle {xMin, yMin, xMax, yMax}
        
        var map = new GioMap();
        
        for(var rect : rectangle){
            map.addObstacle(rect);
        }
        
        return map.findShortest(characterX,characterY,itemX,itemY);
    }
    
    static class GioMap{
        static final int MAX = 102;
        static final int SCALE = 2;
        final Boolean[][] map;
        
        GioMap(){
            map = new Boolean[MAX * SCALE][MAX * SCALE];
        }
        
        void addObstacle(int[] position){
            int xMin = position[0] * SCALE;
            int xMax = position[2] * SCALE;
            int yMin = position[1] * SCALE;
            int yMax = position[3] * SCALE;
            
            for(int x = xMin; x <= xMax; x++){
                for(int y = yMin; y <= yMax; y++){
                    if(x == xMin || x == xMax || y == yMin || y == yMax){
                        if(map[x][y] == null){
                            map[x][y] = true;
                            continue;
                        }
                        
                        if(map[x][y] == true){
                            continue;
                        }
                        
                    }
                    map[x][y] = false;
                }
            }
        }
        
        int findShortest(int characterX, int characterY, int itemX, int itemY){
            for(var points : map){
                String b = "";
                for(var point : points){
                    if(point == null || point == false){
                        b += "-";
                    }else{
                        b += "o";
                    }
                }
                
                System.out.println(b);
            }
            var queue = new LinkedList<int[]>();
            queue.offer(new int[]{characterX * SCALE, characterY * SCALE, 0});
            
            while(!queue.isEmpty()){
                var curr = queue.poll();

                int x = curr[0];
                int y = curr[1];
                int count = curr[2];
                
                if(x < 0 || x > MAX || y < 0 || y > MAX){
                    continue;
                }
                
                if(!Boolean.TRUE.equals(map[x][y])){
                    continue;
                }
                
                if(x == itemX * SCALE && y == itemY * SCALE){
                    return count/2;
                }
                
                map[x][y] = false;
                
                queue.offer(new int[]{x+1, y, count + 1});
                queue.offer(new int[]{x-1, y, count + 1});
                queue.offer(new int[]{x, y+1, count + 1});
                queue.offer(new int[]{x, y-1, count + 1});
            }
            return -1;
        }
    }
}