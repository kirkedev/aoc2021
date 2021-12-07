package day7

import kotlin.math.abs

fun move(from: Int, to: Int): Int =
    abs(to - from)

fun move(positions: List<Int>, to: Int): Int =
    positions.sumOf { move(it, to) }

fun main() = getCrabs().let { positions ->
    IntRange(0, positions.maxOf { it })
        .minOf { position -> move(positions, position) }
        .run(::println)
}
