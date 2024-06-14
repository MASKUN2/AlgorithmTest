class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int[] qArr = queries[i];
            int s = qArr[0];
            int e = qArr[1];
            int k = qArr[2];
            for(int j = s; j <= e; j++){
                if(j % k == 0){
                    arr[j]++;
                }
            }
        }
        
        int[] answer = arr;
        return answer;
    }
}