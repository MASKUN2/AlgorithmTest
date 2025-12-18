import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cityCnt;
    static int routeCnt;
    static List<Route>[] cityRoutes;
    static long[] times;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args){
        init();
        boolean hasNegativeCycle = bellmanFord();

        if(hasNegativeCycle){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i <= cityCnt; i++){
                long time = times[i];
                if(time ==  INF){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(time).append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }

    static boolean bellmanFord(){
        for(int i = 1; i <= cityCnt - 1; i++){   // n - 1  times
            for(int j = 1; j <= cityCnt; j++){ // to all edges
                for(Route r : cityRoutes[j]){
                    relax(r);
                }
            }
        }

        for(int j = 1; j <= cityCnt; j++){ // to all edges
            for(Route r : cityRoutes[j]){
                if(relax(r)) return true;
            }
        }

        return false;
    }

    static boolean relax(Route r){
        long fromTime = times[r.from];
        long oldToTime = times[r.to];
        long newToTime = fromTime + r.time;
        if(fromTime != INF && newToTime < oldToTime){
            times[r.to] = newToTime;
            return true;
        }
        return false;
    }

    static void init(){
        var st = new StringTokenizer(readLine());
        cityCnt = parseInt(st.nextToken());
        routeCnt = parseInt(st.nextToken());

        times = new long[cityCnt + 1]; //start from 1
        Arrays.fill(times, INF); // init as INF;
        times[1] = 0;

        cityRoutes = new ArrayList[cityCnt + 1]; //start from 1
        for(int i = 0; i < cityRoutes.length; i ++){
            cityRoutes[i] = new ArrayList<>();
        }

        for(int i = 0; i < routeCnt; i ++){
            Route r = nextRoute();
            cityRoutes[r.from].add(r);
        }


    }

    static Route nextRoute(){
        var st = new StringTokenizer(readLine());
        var r = new Route();
        r.from =parseInt(st.nextToken());
        r.to =parseInt(st.nextToken());
        r.time =parseInt(st.nextToken());
        return r;
    }

    static String readLine(){
        try{
            return br.readLine();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    static int parseInt(String str){
        return Integer.parseInt(str);
    }

    static class Route{
        int from;
        int to;
        int time;
    }

}