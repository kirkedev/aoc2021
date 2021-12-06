package day4

import lib.getLines

fun main() {
    val bingo = parse(getLines("day4").iterator()).let { (numbers, boards) ->
        numbers.asSequence().runningFold(boards) { games, move ->
            games.map { game -> game.call(move) }
        }.first { games -> games.any(Board::bingo) }
    }.first(Board::bingo)

    println(bingo.score)
}
