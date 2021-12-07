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

    private val dx: Int
        get() = end.first.compareTo(start.first)

    private val dy: Int
        get() = end.second.compareTo(start.second)

    val points: Sequence<Point>
        get() = Point(dx, dy).let { delta ->
            generateSequence(start::copy) { point ->
                point.takeUnless(end::equals)?.let(delta::plus)
            }
        }
}

fun parse(line: String): Line =
    line.split(" -> ").flatMap {
        it.split(',').map(String::toInt)
    }.let { (x1, y1, x2, y2) ->
        Line(Point(x1, y1), Point(x2, y2))
    }

fun parseLines(input: Sequence<String>) =
    input.map(::parse)
