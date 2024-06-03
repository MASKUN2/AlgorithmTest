import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        List<Cell> cells = new ArrayList<>();
        final int length = board.length;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                cells.add(new Cell(i,j,board[i][j]));
            }
        }
        
        int answer = (int)cells.stream()
            .filter(c -> c.isNearSameColour(h,w,board[h][w]))
            .count();
        return answer;
    }
    
    class Cell{
        final int h;
        final int w;
        final String colour;
        
        Cell(int h, int w, String colour){
            this.h = h;
            this.w = w;
            this.colour = colour;
        }
        
        boolean isNearSameColour(int h, int w, String colour){
            return ((this.h == h - 1 && this.w == w)||
                (this.h == h + 1 && this.w == w)||
                (this.h == h && this.w == w - 1) ||
                (this.h == h && this.w == w + 1))&&
                (this.colour.equals(colour));
        }
    }
}