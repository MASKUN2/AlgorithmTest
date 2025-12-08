/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	340808	112573	73632	31.223%
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.

다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데,
이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
*/
import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] a;

    public static void main(String[] args) throws IOException{
        a = new int[Integer.parseInt(br.readLine())];

        int i = 0;
        for(String string : br.readLine().split(" ")){
            a[i++] = Integer.parseInt(string);
        }
        Arrays.sort(a);

        br.readLine();
        StringBuilder sb = new StringBuilder();
        for(String string : br.readLine().split(" ")){
            int x = Integer.parseInt(string);
            if(Arrays.binarySearch(a, x) >= 0){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());

    }
}
