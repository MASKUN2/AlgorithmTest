import java.util.*;
class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        char[] chars = code.toCharArray();
        for(int i = 0; i < chars.length; i ++){
            boolean odd = (i % 2 == 1);
            if(chars[i] == '1'){
                mode = mode == 0? 1 : 0;
                continue;
            }
            sb.append(mode == 1 && odd? chars[i] : mode == 0 && !odd ? chars[i]: "");
        }
        return sb.toString().isEmpty()? "EMPTY": sb.toString();
    }
}