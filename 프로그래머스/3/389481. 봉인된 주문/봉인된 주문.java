/*
1자리부터 시작 a to z;
2번째부터 aa to az;
.. 반복;

1 a
2 b
3 c
4 d
5 e
6 f
7 g
8 h
9 i
10 j
11 k
12 l
13 m
14 n
15 o
16 p
17 q
18 r
19 s
20 t
21 u
22 v
23 w
24 x
25 y
26 z
*/
import java.util.*;

class Solution {
    static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; 
    
    public String solution(long n, String[] bans) {
        long[] banOrder = new long[bans.length];
        
        for(int i = 0; i < bans.length; i++){
            banOrder[i] = getSpellOrder(bans[i]);
        }
        
        Arrays.sort(banOrder);
        
        for(int i = 0; i < banOrder.length; i++){
            if(n >= banOrder[i]){
                n++;
            }
        }
        
        return getSpell(n);
    }
    
    static long getSpellOrder(String spell){
        long order = 0L;
        String[] spells = spell.split("");
        
        for(long d = 1 ; spells.length - d  >= 0; d++ ){
            String target = spells[(int) (spells.length - d)];
            long alphabetOrder = getAlphabetOrder(target);

            order = order + (alphabetOrder * (long) Math.pow(alphabet.length, d - 1));
        }
        return order;
    }

    static String getSpell(long n){
        long l = (long) alphabet.length;
        String spell = "";

        while (n > 0){
            n--; // 26으로 나눌때 n이 26이면 실제로는 인덱스 25 (z)가 나와야하므로, 27은 aa(0,25)여야함 
            spell = alphabet[(int) (n % l)] + spell;
            n /= l;
        }

        return spell;

    }

    static long getAlphabetOrder(String c){
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i].equals(c)) return i + 1;
        }
        return -1;
    }
}