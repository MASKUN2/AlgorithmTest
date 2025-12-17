import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int nodeCount;
    static int edgeCount;
    static int requiredDistance;
    static int startNode;
    static List<Integer>[] edgeMap; // idx = node ID , value = 연결노드
    static int[] d;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args){
        int[] init = read(4);
        nodeCount = init[0];
        edgeCount = init[1];
        requiredDistance = init[2];
        startNode = init[3];

        edgeMap = new ArrayList[nodeCount + 1]; // 노드는 1부터 시작
        for(int i=0; i<edgeMap.length; i++){
            edgeMap[i]= new ArrayList<Integer>();
        }

        for(int i=0; i<edgeCount; i++){
            int[] edgeInfo = read(2);
            edgeMap[edgeInfo[0]].add(edgeInfo[1]); // 연결정보 등록
        }

        d = new int[nodeCount+1];
        Arrays.fill(d, INF);
        d[startNode] = 0;

        dikstra();

        printResult();

    }

    static int[] read(int length){
        try{
            int[] arr = new int[length];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            return arr;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    static void dikstra(){
        // int[0] 노드번호, int[1] 계산된 가중치거리
        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));

        // 초기화
        q.offer(new int[]{startNode, d[startNode]});
        

        while(!q.isEmpty()){
            int[] a = q.poll();
            int fromNode = a[0];
            int fromDistance = a[1];

            if(d[fromNode] < fromDistance) continue;

            for(int toNode : edgeMap[fromNode]){
                int oldToDistance = d[toNode];
                int newToDistance = fromDistance + 1;
                if(newToDistance < oldToDistance){
                    d[toNode] = newToDistance;
                    q.offer(new int[] {toNode, newToDistance});
                }
            }
        }

    }

    static void printResult(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<d.length; i++){
            if(d[i] == requiredDistance){
                sb.append(i).append("\n");
            }
        }

        String result = sb.toString();
        if(result.isEmpty()){
            result = "-1";
        }
        System.out.println(result);
    }
}
