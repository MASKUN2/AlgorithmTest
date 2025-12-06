/*
오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.

첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 
같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
*/
import java.util.*;
import java.io.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int trgLvl = 4;
    static int n;
    static int m;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args){
        n = sc.nextInt();
        m = sc.nextInt();
        
        arr = new ArrayList[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < m; i++){
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            arr[f1].add(f2);
            arr[f2].add(f1);
        }
        
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(find(i, 0)){
                System.out.println(1);
                return;
            }
        }
        
        System.out.println(0);
    }
    
    static boolean find(int i, int lvl){
        visited[i] = true;
        
        if(lvl == trgLvl){
            return true;
        }
        
        for(int j : arr[i]){
            if(visited[j]){
                continue;
            }
            
            if(find(j, lvl + 1)){
                return true;
            }
        }
        
        return visited[i] = false;
    }
    
}