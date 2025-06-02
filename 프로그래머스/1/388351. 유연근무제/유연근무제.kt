class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = schedules.size
        for(i in schedules.indices){
            var schedule = schedules[i].plus(10)
            if(schedule.mod(100) >= 60){
                schedule = schedule.div(100)*100 + 100 + schedule.mod(100) - 60
            }
            for(j in 0..6){
                val day = (startday - 1 + j) % 7
                if(day == 5 || day == 6) continue
                val timelog = timelogs[i][j]
                if(timelog <= schedule){
                    continue
                }else{
                    answer--
                    break
                }
            }
            
        }
        return answer
    }
}