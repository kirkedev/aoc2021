package day2

data class AimedPosition(
    val horizontal: Int = 0,
    val depth: Int = 0,
    val aim: Int = 0
) {
    fun move(direction: Direction, distance: Int): AimedPosition =
        when (direction) {
            Direction.Forward -> AimedPosition(horizontal + distance, depth + aim * distance, aim)
            Direction.Up -> AimedPosition(horizontal, depth, aim - distance)
            Direction.Down -> AimedPosition(horizontal, depth, aim + distance)
        }
}

fun main() {
    val position = getCommands().fold(AimedPosition()) { position, (direction, distance) ->
        position.move(direction, distance)
    }

    println(position.horizontal * position.depth)
}
