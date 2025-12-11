import java.util.*;

class Solution {
    static int[][] points;
    static int[][] routes;
    
    // 인덱스: 로봇의 순서, [i][0] 현재 좌표 r, [i][1] 현재 좌표 c, [i][2] 다음루트 인덱스(없다면 -1로 초기화)
    static int[][] robot;
    static int conflictCount = 0;

    public int solution(int[][] p, int[][] r) {
        points = p;
        routes = r;
        robot = new int[r.length][3];
        for(int i = 0; i < robot.length; i++){
            int[] startPoint = points[routes[i][0] - 1];
            robot[i][0] = startPoint[0];
            robot[i][1] = startPoint[1];
            robot[i][2] = 1;
        }
    
        while(!end()){
            countConflict();
            moveRobot();
        }
        
        return conflictCount;
    }
    
    void countConflict(){
        Set<List<Integer>> countedPoint = new HashSet<>();
        
        for(int i = 0; i < robot.length; i++){
            if(robot[i][2] == -1) continue;
            int r = robot[i][0];
            int c = robot[i][1];
            for(int j = 0; j < robot.length; j++){
                if(i == j) continue;
                if(robot[j][2] == -1) continue;
                int r_ = robot[j][0];
                int c_ = robot[j][1];
                
                if(r == r_ && c == c_){
                    if(countedPoint.add(List.of(r, c))){
                        conflictCount++;
                    }
                }
            }
        }
    }
    
    void moveRobot(){
        for(int i = 0; i < robot.length; i++){
            if(robot[i][2] == -1) continue;
            int r = robot[i][0];
            int c = robot[i][1];
            
            int nextRouteIdx = robot[i][2];
            int nextPontNumber = routes[i][nextRouteIdx];
            int r_ = points[nextPontNumber - 1][0];
            int c_ = points[nextPontNumber - 1][1];
            
            if(r == r_ && c == c_){
                if(nextRouteIdx == routes[i].length - 1){
                    robot[i][2] = -1;
                    continue;
                }
                robot[i][2]++;
                nextPontNumber = routes[i][nextRouteIdx + 1];
                
                r_ = points[nextPontNumber -1][0];
                c_ = points[nextPontNumber -1][1];
                
            }
            
            if(r < r_) {
                r++; 
            }else if(r > r_){
                r--;
            }else if(c < c_){
                c++;
            }else if(c > c_){
                c--;
            }
            
            robot[i][0] = r;
            robot[i][1] = c;
        }
    }
    
    boolean end(){
        for(int i = 0; i < robot.length; i++){
            if(robot[i][2] != -1) return false;
        }
        
        return true;
    }
    
}