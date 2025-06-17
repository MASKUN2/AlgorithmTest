class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] chars = t.toCharArray();
        int window = p.length();
        long reference = Long.valueOf(p);
        for(int i = 0; i < chars.length - window + 1 ; i ++){
            String temp = "";
            for(int j = 0; j < window; j ++){
                temp = temp + chars[i + j];
            }
            long compare = Long.valueOf(temp);
            if(compare <= reference){
                answer++;
            }   
        }
        return answer;
    }
}