/*
방향 없는 그래프가 주어졌을 때,
연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)

둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.
*/
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        Pair init = read();
        final int nodeCount = init.first;
        final int edgeCount = init.second;

        Graph graph = new Graph(nodeCount);

        for(int i = 0; i < edgeCount; i++){
            Pair pair = read();
            int id1 = pair.first;
            int id2 = pair.second;

            graph.bind(id1, id2);
        }

        System.out.println(graph.getConnectedComponentCount());
    }

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static Pair read(){
        try{
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            return new Pair(Integer.parseInt(tokenizer.nextToken()),
                    Integer.parseInt(tokenizer.nextToken()));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    static class Graph{
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        final ArrayList<Integer>[] array;

        Graph(int size){
            array = new ArrayList[size];

            for(int i=0; i < size; i++){
                array[i] = new ArrayList<>();
            }
        }

        void bind(int i1, int i2){
            array[i1 - 1].add(i2 - 1);
            array[i2 - 1].add(i1 - 1);
        }

        int getConnectedComponentCount(){
            int count = 0;
            boolean[] visited = new boolean[array.length];

            for(int i = 0; i < array.length; i++){
                if(visited[i]){
                    continue;
                }

                count++;
                visitAll(i, visited);
            }

            return count;
        }

        void visitAll(int i, boolean[] visited){
            if(visited[i]){
                return;
            }
            visited[i] = true;

            for(int j : array[i]){
                visitAll(j, visited);
            }
        }
    }
}
