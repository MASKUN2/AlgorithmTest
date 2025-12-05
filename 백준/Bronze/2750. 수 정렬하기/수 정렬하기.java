/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
둘째 줄부터 N개의 줄에는 수가 주어진다. 
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/

import java.util.*;
import java.io.*;

public class Main{
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        final int size = read();
        int[] array = new int[size];
        
        for(int i = 0; i < size; i++){
            array[i] = read();
        }
        
        bubbleSort(array);
        
        for(int value : array){
            System.out.println(value);
        }
    }
    
    static int read(){
        return scanner.nextInt();
    }
    
    static void bubbleSort(int[] array){
        final int size = array.length;
        
        if(size <= 1){
            return;
        }
        
        int endIndex = size -1;
        int currentIndex = 0;
        int nextIndex = 1;
        
        while(endIndex > 0){
            int current = array[currentIndex];
            int next = array[nextIndex];
            
            if(current > next){
                array[currentIndex] = next;
                array[nextIndex] = current;
            }
            
            if(nextIndex == endIndex){
                currentIndex = 0;
                nextIndex = 1;
                endIndex--;
                continue;
            }
            currentIndex++;
            nextIndex++;
        }
    }
}