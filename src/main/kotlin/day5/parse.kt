package day5

typealias Point = Pair<Int, Int>

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
        get() = sequence {
            val dx = end.first.compareTo(start.first)
            val dy = end.second.compareTo(start.second)
            var point = start.copy()

            while (point != end) {
                yield(point)
                point = Point(point.first + dx, point.second + dy)
            }

            yield(point)
        }
}

fun parse(line: String): Line {
    val (x1, y1, x2, y2) = line.split(" -> ").flatMap { it.split(',').map(String::toInt) }
    return Line(Point(x1, y1), Point(x2, y2))
}

fun parseLines(input: Sequence<String>) =
    input.map(::parse)
