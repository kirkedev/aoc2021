package day4

import lib.getLines

fun main() {
    val (calls, boards) = parse(getLines("day4").iterator())

    val (move, board) = calls.asSequence().runningFold(Pair(0, boards)) { (move, boards), number ->
        Pair(move + 1, boards.map { board -> board.call(number) }.filterNot(Board::bingo))
    }.first { (_, boards) -> boards.size == 1 }

    val bingo = calls.asSequence().drop(move)
        .runningFold(board[0]) { board, number -> board.call(number) }
        .first(Board::bingo)

    println(bingo.score)
}
