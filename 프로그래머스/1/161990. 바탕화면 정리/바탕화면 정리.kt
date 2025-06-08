class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var lux = Int.MAX_VALUE 
        var luy = Int.MAX_VALUE
        var rdx = Int.MIN_VALUE 
        var rdy = Int.MIN_VALUE 

        for ((y, row) in wallpaper.withIndex()) {
            for ((x, char) in row.withIndex()) {
                if (char == '#') {
                    lux = minOf(lux, x)
                    luy = minOf(luy, y)
                    rdx = maxOf(rdx, x + 1) 
                    rdy = maxOf(rdy, y + 1) 
                }
            }
        }
        return intArrayOf(luy, lux, rdy, rdx)
    }
}