package day2

enum class Direction {
    Forward,
    Up,
    Down;

    companion object {
        fun from(direction: String): Direction =
            when (direction) {
                "forward" -> Forward
                "up" -> Up
                "down" -> Down
                else -> throw Exception("Invalid direction: $direction")
            }
    }
}
