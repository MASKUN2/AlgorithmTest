import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String,Integer> colMap = new HashMap<>();
        colMap.put("code", 0);
        colMap.put("date", 1);
        colMap.put("maximum", 2);
        colMap.put("remain", 3);
        
        int extIdx = colMap.get(ext);
        int sortIdx = colMap.get(sort_by);
        
        List<int[]> filtered = new ArrayList<>();
        for(var row : data){
            if (row[extIdx] < val_ext){
                filtered.add(row);
            }
        }
        var sorted = filtered.stream().sorted(Comparator.comparing(row -> row[sortIdx])).toArray(int[][]::new); 
        
        int[][] answer = sorted;
        return answer;
    }
}