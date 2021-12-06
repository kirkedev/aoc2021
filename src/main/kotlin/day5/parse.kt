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
            val run = end.first.minus(start.first).let { delta ->
                IntProgression.fromClosedRange(start.first, end.first, if (delta < 0) -1 else 1)
            }

            val rise = end.second.minus(start.second).let { delta ->
                IntProgression.fromClosedRange(start.second, end.second, if (delta < 0) -1 else 1)
            }

            for (x in run) {
                for (y in rise) {
                    yield(Point(x, y))
                }
            }
        }
}


fun parse(line: String): Line {
    val (x1, y1, x2, y2) = line.split(" -> ").flatMap { it.split(",").map(String::toInt) }
    return Line(Point(x1, y1), Point(x2, y2))
}

fun parseLines(input: Sequence<String>) =
    input.map(::parse)
