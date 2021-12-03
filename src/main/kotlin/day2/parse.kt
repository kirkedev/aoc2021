package day2

import lib.getLines

fun parse(input: String): Pair<Direction, Int> =
    input.split(" ").let { (direction, distance) ->
        Pair(Direction.from(direction), distance.toInt())
    }

fun getCommands(): Sequence<Pair<Direction, Int>> =
    getLines("day2").map(::parse)
