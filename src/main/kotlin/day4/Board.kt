package day4

fun <T> rows(squares: List<T>): Sequence<List<T>> = sequence {
    for (row in 0 until 5) {
        yield(squares.subList(row * 5, row * 5 + 5))
    }
}

fun <T> columns(squares: List<T>): Sequence<List<T>> = sequence {
    for (column in 0 until 5) {
        yield((0 until 5).map { row -> squares[row * 5 + column] })
    }
}

typealias Square = Pair<Int, Boolean>

class Board(val numbers: IntArray) {
    private val called = mutableListOf<Int>()

    private val marks: Sequence<Boolean>
        get() = numbers.asSequence().map { square -> called.indexOf(square) > -1 }

    val squares: Sequence<Square>
        get() = numbers.asSequence().zip(marks)

    val rows: Sequence<List<Square>>
        get() = rows(squares.toList())

    val columns: Sequence<List<Square>>
        get() = columns(squares.toList())

    val bingo: Boolean
        get() {
            val marked = marks.toList()
            return rows(marked).any { row -> row.all { it } } || columns(marked).any { column -> column.all { it } }
        }

    val score: Int
        get() = if (bingo)
            squares.filterNot { (_, marked) -> marked }.sumOf { (number, _) -> number } * called.last()
        else 0

    fun call(vararg calls: Int): Board {
        val matches = calls.filter { numbers.indexOf(it) > -1 }.toList()

        return when (matches.size) {
            0 -> this
            1 -> called.add(matches[0]).let { this }
            else -> called.addAll(matches).let { this }
        }
    }
}
