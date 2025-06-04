class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val pointMap: Map<Loc, Point> = park.map { it.toCharArray() }
            .mapIndexed { i, chars ->
                chars.mapIndexed { j, c ->
                    Point(Loc(j, i), LocType.valueOf(c.toString()))
                }
            }
            .flatten()
            .associateBy { it.loc }

        pointMap.values.forEach { p ->
            val southLoc = Loc(p.loc.x, p.loc.y + 1)
            pointMap[southLoc]?.let { southNeighbor ->
                p.join(Direction.S, southNeighbor)
            }

            val eastLoc = Loc(p.loc.x + 1, p.loc.y)
            pointMap[eastLoc]?.let { eastNeighbor ->
                p.join(Direction.E, eastNeighbor)
            }
        }

        var currentPoint: Point = pointMap.values.find { it.locType == LocType.S }!!
        
        routes.forEach { route ->
            val parts = route.split(" ")
            val distance = parts[1].toInt()

            val moveDir = Direction.valueOf(parts[0])

            var tempDestPoint = currentPoint
            var canMoveThisRoute = true
            
            for (step in 1..distance) {
                val nextStepPoint = tempDestPoint.get(moveDir)

                if (nextStepPoint == null) {
                    canMoveThisRoute = false
                    break
                }
                if (nextStepPoint.locType == LocType.X) {
                    canMoveThisRoute = false
                    break
                }
                tempDestPoint = nextStepPoint
            }

            if (canMoveThisRoute) {
                currentPoint = tempDestPoint
            }
        }
        
        return intArrayOf(currentPoint.loc.y, currentPoint.loc.x)
    }
}

fun Point.get(d: Direction): Point? = this.map[d]

fun Point.join(d: Direction, point: Point) {
    this.map[d] = point
    point.map[d.opposite()] = this
}

data class Point(
    val loc: Loc,
    val locType: LocType,
    val map: MutableMap<Direction, Point> = mutableMapOf()
)

data class Loc(
    val x: Int,
    val y: Int
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