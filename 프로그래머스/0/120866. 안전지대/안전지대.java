import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] board) {
        int size = board.length;
        
        Board b = new Board();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell c = new Cell();
                c.xAxis = i;
                c.yAxis = j;
                c.gotBomb = board[i][j] == 1;
                c.isSafe = board[i][j] != 1;
                b.cells.add(c);
            }
        }
        
        int answer = b.determineSafeCellNum();
        return answer;
    }
    
    class Board{
        Set<Cell> cells = new HashSet<>();
        
        int determineSafeCellNum(){
            for(Cell c : cells){
                if(c.gotBomb){
                    findNear(c).forEach(cell-> cell.isSafe = false);
                }
            }
            return (int)cells.stream().filter(cell -> cell.isSafe).count();
        }
        
        Stream<Cell> findNear(Cell c){
            return cells.stream().filter(cell -> cell.isNear(c));
        }
    }
    
    
    class Cell{
        int xAxis = 0;
        int yAxis = 0;
        boolean gotBomb;
        boolean isSafe;
        
        boolean isNear(Cell c){
            return xAxis <= c.xAxis+1 &&
                xAxis >= c.xAxis-1 &&
                yAxis <= c.yAxis+1 &&
                yAxis >= c.yAxis-1;
        }
    }
}