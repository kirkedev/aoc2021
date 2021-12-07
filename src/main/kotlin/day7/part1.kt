package day7

fun main() {
    val positions = getCrabs()
    positions.toSet().minOf { position -> move(positions, position) }.run(::println)
}
