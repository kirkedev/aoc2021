package day7

fun aggregateMoves(positions: List<Int>, position: Int): Int =
    positions.sumOf {
        distance(it, position).let { distance ->
            distance * distance.inc() / 2
        }
    }

fun main() =
    getCrabs().let { positions ->
        IntRange(0, positions.maxOrNull() ?: 0).minOf { position ->
            aggregateMoves(positions, position)
        }
    }.run(::println)
