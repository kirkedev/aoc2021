package day5

import lib.getLines

fun main() {
    val lines = parseLines(getLines("day5")).toList()
    val width = lines.maxOf { (start, end) -> maxOf(start.first, end.first) }.inc()
    val height = lines.maxOf { (start, end) -> maxOf(start.second, end.second) }.inc()

    lines.fold(Plot(width, height)) { plot, line ->
        plot.draw(line)
    }.let { plot ->
        plot.points.count { it > 1 }
    }.run(::println)
}
