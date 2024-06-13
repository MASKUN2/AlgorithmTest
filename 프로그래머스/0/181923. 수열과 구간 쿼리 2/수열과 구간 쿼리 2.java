class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length ; i++){
            int[] query = queries[i];
            
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            int find = -1;
            for(int j = s; j <= e; j++){
                int num = arr[j];
                if(num > k && find == -1){
                    find = num;
                    continue;
                }
                if(num > k && num < find){
                    find = num;
                }
            }
            answer[i] = find;
        }
        return answer;
    }
}