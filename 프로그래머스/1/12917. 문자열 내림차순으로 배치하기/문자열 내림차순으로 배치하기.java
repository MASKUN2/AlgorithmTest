class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        
        for(int j = 1; j < charArr.length; j++){
            for(int i = 0; i < charArr.length - j ; i++){
                if(charArr[i] < charArr[i+1]){
                    char temp = charArr[i];
                    charArr[i] = charArr[i+1];
                    charArr[i+1] = temp;
                } 
            }
        }
        String answer = new String(charArr);
        return answer;
    }
}