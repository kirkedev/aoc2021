package day4

import lib.getLines

fun main() {
    val bingo = parse(getLines("day4").iterator()).let { (numbers, boards) ->
        numbers.asSequence().runningFold(boards) { boards, move ->
            boards.map { board -> board.call(move) }
        }.first { boards -> boards.any(Board::bingo) }
    }.first(Board::bingo)

    println(bingo.score)
}
