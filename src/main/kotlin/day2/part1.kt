package day2

data class Position(
    val horizontal: Int = 0,
    val depth: Int = 0
) {
    fun move(direction: Direction, distance: Int): Position =
        when (direction) {
            Direction.Forward -> Position(horizontal + distance, depth)
            Direction.Up -> Position(horizontal, depth - distance)
            Direction.Down -> Position(horizontal, depth + distance)
        }
}

fun main() {
    val position = getCommands().fold(Position()) { position, (direction, distance) ->
        position.move(direction, distance)
    }

    println(position.horizontal * position.depth)
}
