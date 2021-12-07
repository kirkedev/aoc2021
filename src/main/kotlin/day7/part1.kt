package day7

import kotlin.math.abs

fun distance(from: Int, to: Int): Int =
    abs(to - from)

fun move(positions: List<Int>, to: Int): Int =
    positions.sumOf { distance(it, to) }

fun main() =
    getCrabs().let { positions ->
        IntRange(0, positions.maxOrNull() ?: 0).minOf { position ->
            move(positions, position)
        }
    }.run(::println)
