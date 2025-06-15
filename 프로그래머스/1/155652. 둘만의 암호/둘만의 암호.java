class Solution {
    public String solution(String s, String skip, int index) {
        char[] chars = s.toCharArray(); 
        char[] skips = skip.toCharArray();
        String answer = "";
        for(int i = 0; i < chars.length; i++){
            char target = chars[i];
            char moved = target;
            for(int j = index; j > 0; j --){
                moved ++;
                if(moved > 'z'){
                    moved = 'a';
                }
                for(int k = 0; k < skips.length; k ++){
                    if(moved == skips[k]){
                        j++;
                        break;
                    }
                }
            }
            answer = answer + moved;
        }    
        return answer;
    }
}