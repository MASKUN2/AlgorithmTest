class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        return find(new int[5], 0 , n, q, ans);
    }
    
    int find(int[] arr,int idx , int n, int[][] q, int[] ans){
        if(idx == 5){
            return isOk(arr, q, ans) ? 1 : 0;
        }
        
        int prev = idx > 0 ? arr[idx - 1] : 0 ;
        
        int count = 0;
        
        for(int i = prev + 1; i <= n; i++){
            arr[idx] = i;
            count += find(arr, idx + 1, n, q, ans);
        }
        
        arr[idx] = 0;
        
        return count;
    }
    
    boolean isOk(int[] arr, int[][] q, int[] ans){
        for(int i = 0; i < q.length; i ++){
            int includes = 0;
            for(int n : arr){
                for(int t : q[i]){
                    if(n == t){
                        includes += 1;
                        break;
                    }
                }
            }
            
            if(includes != ans[i]){
                return false;
            }
        }
        return true;
    }
}