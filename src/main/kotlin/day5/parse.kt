package day5

typealias Point = Pair<Int, Int>

operator fun Point.plus(other: Point): Point =
    Point(this.first + other.first, this.second + other.second)

data class Line(
    val start: Point,
    val end: Point
) {
    val isVertical: Boolean
        get() = start.first == end.first

    val isHorizontal: Boolean
        get() = start.second == end.second

    val isStraight: Boolean
        get() = isVertical || isHorizontal

    val points: Sequence<Point>
        get() {
            val dx = end.first.compareTo(start.first)
            val dy = end.second.compareTo(start.second)

            return Pair(dx, dy).let { delta ->
                generateSequence(start::copy) { point ->
                    takeUnless { point == end }?.let { point + delta }
                }
            }
        }
}

fun parse(line: String): Line {
    val (x1, y1, x2, y2) = line.split(" -> ").flatMap { it.split(',').map(String::toInt) }
    return Line(Point(x1, y1), Point(x2, y2))
}

fun parseLines(input: Sequence<String>) =
    input.map(::parse)
