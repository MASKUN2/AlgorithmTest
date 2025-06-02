class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = schedules.size
        for(i in schedules.indices){
            var schedule = schedules[i].plus(10)
            if(schedule.mod(100) >= 60){
                schedule = schedule.div(100).plus(1).times(100).plus(schedule.mod(100).minus(60))
            }
            for(j in 0..6){
                val day = (startday + j) % 7
                if(day == 6 || day == 0) continue
                if(timelogs[i][j] > schedule){
                    answer--
                    break
                }
            }
            
        }
        return answer
    }
}