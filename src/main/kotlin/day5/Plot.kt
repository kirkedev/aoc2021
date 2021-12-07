package day5

class Plot(width: Int, private val height: Int) {
    val points = IntArray(width * height)

    fun draw(point: Point) =
        point.let { (x, y) ->
            points[y * height + x] += 1
        }

    fun draw(line: Line): Plot =
        line.points.forEach(::draw).let { this }

    fun get(point: Point): Int =
        point.let { (x, y) -> points[y * height + x] }
}
