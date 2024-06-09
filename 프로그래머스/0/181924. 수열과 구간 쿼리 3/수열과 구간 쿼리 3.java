class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] q : queries){
            int i = q[0];
            int j = q[1];
            int tmp = 0;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        int[] answer = arr;
        return answer;
    }
}