package day5

import lib.getLines

fun main() {
    val lines = parseLines(getLines("day5")).toList()
    val width = lines.maxOf { maxOf(it.start.first, it.end.first) } + 1
    val height = lines.maxOf { maxOf(it.start.second, it.end.second) } + 1
    val plot = lines.fold(Plot(width, height)) { plot, line -> plot.draw(line) }

    println(plot.points.count { it > 1 })
}
