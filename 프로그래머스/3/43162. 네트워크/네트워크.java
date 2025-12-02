import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[][] computers) {
        var nw = new Network(n);
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(computers[r][c] == 1){
                    nw.wind(r,c);
                }
            }
        }
        
        return nw.getCount();
    }
    
    static class Network{
        final HashSet[] connections;
        
        Network(int nodeSize){
            this.connections = new HashSet[nodeSize];
            IntStream.range(0, nodeSize)
                .forEach(i -> this.connections[i] = new HashSet<Integer>());
        }
        
        void wind(int node1, int node2){
            this.connections[node1].add(node2);
            this.connections[node2].add(node1);
        }
        
        int getCount(){
            final int nodeSize = connections.length;
            var visited = new boolean[nodeSize];
         
            int count = 0;
            for(int i = 0; i < nodeSize; i++){
                if(visited[i]){
                    continue;
                }
                visitConnected(i, visited);
                count++;
            }
            
            return count;
        }
        
        void visitConnected(int node, boolean[] visitMap){
            if(visitMap[node]){
                return;
            }
            
            visitMap[node] = true;
            
            for(Integer connectedNode : (Set<Integer>) connections[node]){
                visitConnected(connectedNode, visitMap);
            }
        }
        
    }
}