import java.util.*;
// 대기열 중 작업시간이 가장 작은 것을 우선적으로 처리해야한다(SJF 알고리즘). 
// 대기 중인 작업의 수(w)는 처리 가능한 작업의 수(A) 보다 항상 많거나 같기 때문에 처리할 작업의 소요시간(S)의 곱만큼의 지연이 발생한다. (W-A)*S > A*S 
class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();

                for(int[] i : jobs){
                    Job job = new Job(i);
                    jobList.add(job);
                }
                int answer = 0;
                int currentTime = 0;
                int size = jobList.size();
                while(!jobList.isEmpty()){
                    final int _currentTime = currentTime;
                    Optional<Job> jobOpt = jobList.stream().filter(j -> j.reqTime <= _currentTime).sorted((a, b)-> a.useTime - b.useTime).findFirst();
                    if(jobOpt.isEmpty()){
                        currentTime++;
                        continue;
                    }
                    Job job = jobOpt.get();
                    currentTime += job.useTime;
                    answer += currentTime - job.reqTime;
                    jobList.remove(job);
        }
        
        
        return answer / size;
    }
    
    static class Job{
        int reqTime = 0;
        int useTime = 0;
        
        Job(int[] i){
            this.reqTime = i[0];
            this.useTime = i[1];
        }
    }
}
