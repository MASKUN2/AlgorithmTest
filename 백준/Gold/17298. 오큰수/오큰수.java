/*
크기가 N인 수열 . 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 
그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. 
A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.

ex) 
4
3 5 2 7

5 7 7 -1
*/
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        MyOckn myOckn = new MyOckn(size);
        
        for(int i = 0; i < size; i++){
            int seq = Integer.parseInt(tokenizer.nextToken());
            myOckn.put(seq);
        }
        
        System.out.print(myOckn.getResult());
    }
    
    static class MyOckn{
        private final Stack<Sequence> stack = new Stack<>();
        private final int[] result;
        private int index = 0;
        
        MyOckn(int size){
            this.result = new int[size];
        }
        
        void put(final int inputValue){
            result[index] = -1;
            
            while(!stack.empty()){
                Sequence top = stack.peek();
                
                if(top.value >= inputValue){ break;}
                
                result[top.index] = inputValue;
                stack.pop();
            }
            
            stack.push(new Sequence(index++, inputValue));
        }
        
        String getResult(){
            StringBuffer buffer = new StringBuffer();
            for(int i : result){
                buffer.append(i).append(" ");
            }
            return buffer.toString();
        }
    }
    
    static class Sequence{
        final int index;
        final int value;
        
        Sequence(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}