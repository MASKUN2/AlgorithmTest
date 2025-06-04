class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val pointMap: Map<Loc, Point> = park.map { it.toCharArray() }
            .mapIndexed { i, chars -> chars.mapIndexed { j, c -> Point(Loc(j, i), LocType.valueOf(c.toString())) } }
            .flatten()
            .associateBy { it.loc }

        pointMap.values.forEach { pointMap[Loc(it.loc.x, it.loc.y + 1)]?.join(Direction.S, it) }
        pointMap.values.forEach { pointMap[Loc(it.loc.x + 1, it.loc.y)]?.join(Direction.E, it) }

        var currentPoint : Point = pointMap.values.find { it.locType == LocType.S }!!
        

        var answer: IntArray = intArrayOf()
        return answer
    }
}

fun Point.get(d: Direction): Point? = this.map[d]
fun Point.join(d: Direction, point: Point) {
    this.map.put(d, point)
    point.map.put(d.opposite(), this)
}

data class Point(
    val loc: Loc,
    val locType: LocType,
    val map: MutableMap<Direction, Point> = mutableMapOf()
)

data class Loc(
    val x: Int,
    val y: Int,
)

enum class LocType {
    S, O, X
}

fun Direction.opposite(): Direction = when (this) {
    Direction.N -> Direction.S
    Direction.S -> Direction.N
    Direction.W -> Direction.E
    Direction.E -> Direction.W
}

enum class Direction {
    N, S, W, E
}