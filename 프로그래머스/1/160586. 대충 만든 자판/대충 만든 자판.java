class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
            char[] chars = targets[i].toCharArray();
            int totalclick = 0;
            for(int j = 0; j < chars.length; j++){
                char c = chars[j];
                int click = -1;
                for(String str : keymap){
                    int idx = str.indexOf(c);
                    if(idx == -1){
                        continue;
                    }
                    if(idx >= 0){
                        if(click == -1){
                            click = idx +1;
                            continue;
                        }
                        if(click > idx +1){
                            click = idx +1;
                            continue;
                        }
                    }
                }
            if(click == -1){
                totalclick = -1;
                break;
            }   
            totalclick += click;
            }
            
            answer[i] = totalclick;
        }
        return answer;
    }
}