package day7

fun aggregateMoves(positions: List<Int>, position: Int): Int =
    positions.sumOf {
        IntRange(minOf(it, position), maxOf(it, position)).sumOf { step ->
            move(it, step)
        }
    }

fun main() =
    getCrabs().let { positions ->
        IntRange(0, positions.maxOrNull() ?: 0).minOf { position ->
            aggregateMoves(positions, position)
        }
    }.run(::println)
