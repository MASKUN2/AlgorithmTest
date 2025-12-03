import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
    * 1. ArrayDeque로 슬라이딩 윈도우를 구현
    * 2. 해당 윈도우안의 값은 오름차순으로 정렬, 즉 deque의 front는 최소값을 유지
    * 3. deque의 rear와 현재 새로 삽입될 값을 비교, 만약 삽입될 값이 더 작다면, deque의 rear값 제거
    *   (why? - 이후의 값들 중 이미 자신보다 작은 값이 나왔다.
    *       == 슬라이딩 윈도우를 이동하더라도 이제 자신이 최소값일 가능성은 없다.)
    * 4. 새로 삽입될 값이 deque의 rear보다 크다면 이제 deque에 삽입
    *   (why? - 만약 front의 값이 범위를 지나쳐서 윈도우 내부에서 빠져나가면 최소값이 될 확률이 있다.)
    * */

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int N, L;
        ArrayDeque<Num> window = new ArrayDeque<>();

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (window.isEmpty()) window.add(new Num(i, Integer.parseInt(st.nextToken())));
            else {
                int now = Integer.parseInt(st.nextToken());
                if(window.peek().i <= i-L){window.poll();}

                while (!window.isEmpty()&& window.peekLast().v > now) window.pollLast();
                window.add(new Num(i, now));
            }
            ans.append(window.peek().v).append(" ");
        }
        System.out.println(ans);
    }
}

class Num {
    int i;
    int v;

    public Num(int i, int v){
        this.i = i;
        this.v = v;
    }
}