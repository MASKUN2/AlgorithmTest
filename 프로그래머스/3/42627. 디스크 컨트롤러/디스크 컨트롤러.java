import java.util.*;

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