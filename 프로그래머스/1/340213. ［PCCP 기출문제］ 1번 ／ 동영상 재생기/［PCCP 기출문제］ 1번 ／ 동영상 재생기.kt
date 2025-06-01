class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        
         fun Int.opSkip() : Int {
            if(this >= op_start.asSeconds() && this <= op_end.asSeconds()){
                return op_end.asSeconds()
            }else {
                return this
            }
        }
        
        var currSec = pos.asSeconds().opSkip()
        
        for(command in commands){
             if(command == "prev"){
                currSec = currSec.prev().opSkip()
            }else {
                currSec = currSec.next(video_len.asSeconds()).opSkip()
            }
        }
        
        var answer: String = currSec.toTime()
        return answer
    }
    
    fun String.asSeconds() : Int = this.split(":").get(0).toInt().times(60).plus(this.split(":").get(1).toInt())
    fun Int.toTime() : String = this.div(60).toString().padStart(2, '0') +":"+ this.mod(60).toString().padStart(2, '0')
    fun Int.next(limit : Int) : Int {
        if(this.plus(10) > limit){
            return limit
        }else{
            return this.plus(10)
        }
    }
    fun Int.prev() : Int {
        if(this.minus(10) < 0){
            return 0
        }else{
            return this.minus(10)
        }
    }
}