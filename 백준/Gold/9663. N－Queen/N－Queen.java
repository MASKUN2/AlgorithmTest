/*
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
첫째 줄에 N이 주어진다. (1 ≤ N < 15)
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

*/

import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] rows;
    static int count = 0;

    public static void main(String[] args){
        n = sc.nextInt();
        rows = new int[n];

        find(0);

        System.out.println(count);
    }

    static void find(int r){
        if(r == n) {
            count++;
            return;
        }

        for(int c = 0; c < n; c++){
            if(isSafe(r, c)){
                rows[r] = c;
                find(r+1);
            }
        }
    }

    static boolean isSafe(int r, int c){
        for(int i = 0; i < r; i++){
            if(rows[i] == c){
                return false;
            }

            if (Math.abs(i - r) ==  Math.abs(rows[i] - c)){
                //행의 차이 절대값 == 열 차이의 절대값이 같음 : 대각선 위치임
                return false;
            }
        }

        return true;
    }
}

