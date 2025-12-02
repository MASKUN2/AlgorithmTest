import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        var t = new Try();
        t.curr = begin;
        t.target = target;
        t.words.addAll(Arrays.asList(words));
        
        var queue = new LinkedList<Try>();
        queue.offer(t);
        
        while(!queue.isEmpty()){
            var currTry = queue.poll();
            
            if(currTry.isMatch()){
                return currTry.count;
            }
            
            for(var newTry : currTry.transform()){
                queue.offer(newTry);
            }
        }
        
        return 0;
        
    }
    
    class Try{
        String curr;
        String target;
        Set<String> words = new HashSet<>();
        int count = 0;
        
        Try copy(){
            var t = new Try();
            t.curr = this.curr;
            t.target = this.target;
            t.words.addAll(this.words);
            int count = this.count;
            return t;
        }
        
        boolean isMatch(){
            return curr.equals(target);
        }
        
        List<Try> transform(){
            List<Try> list = new ArrayList<>();
            for(String word : this.words){
                if(isTransformable(word)){
                    var t = copy();
                    t.curr = word;
                    t.words.remove(word);
                    t.count = this.count + 1;
                    list.add(t);
                }
            }
            return list;
        }
        
        boolean isTransformable(String word){
            var currChars = this.curr.toCharArray();
            var wordChars = word.toCharArray();
            
            int diff = 0;
            for(int i = 0; i < currChars.length; i++){
                if(currChars[i] != wordChars[i]){
                    diff++;
                }
            }
            
            return diff == 1;
        }
    }
}