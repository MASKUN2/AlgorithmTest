/*
7331은 소수인데, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 이런 숫자를 신기한 소수라고 이름 붙였다.
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
*/
import java.util.*;
import java.io.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int[] firstDigitPrimes = new int[]{2, 3, 5, 7};
    static int[] subDigitPrimes = new int[]{1, 2, 3, 5, 7, 9};
    static int digit;
    static int[][] map;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args){
        digit = sc.nextInt();

        map = new int[digit][];
        map[0] = firstDigitPrimes;
        for(int i = 1; i < digit; i++){
            map[i] = subDigitPrimes;
        }

        for(int i : map[0]){
            find(i, 1);
        }

        for(int i : primes){
            System.out.println(i);
        }
    }

    static void find(int n, int nextRow){
        if(nextRow == digit && isPrime(n)){
            primes.add(n);
            return;
        }

        if(isPrime(n)){
            for(int i : map[nextRow]){
                find(n * 10 + i, nextRow + 1);
            }
        }
    }

    static boolean isPrime(int n){
        for(int i = 2; i * i <= n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
