import day4.Board
import day4.columns
import day4.parse
import day4.rows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun `access a bingo board by columns`() {
        val board = Board(
            intArrayOf(
                14, 21, 17, 24, 4,
                10, 16, 15, 9, 19,
                18, 8, 23, 26, 20,
                22, 11, 13, 6, 5,
                2, 0, 12, 3, 7
            )
        )

        assertThat(columns(board.numbers.toList()).toList()).isEqualTo(
            listOf(
                listOf(14, 10, 18, 22, 2),
                listOf(21, 16, 8, 11, 0),
                listOf(17, 15, 23, 13, 12),
                listOf(24, 9, 26, 6, 3),
                listOf(4, 19, 20, 5, 7)
            )
        )
    }

    @Test
    fun `access a bingo board by rows`() {
        val board = Board(
            intArrayOf(
                14, 21, 17, 24, 4,
                10, 16, 15, 9, 19,
                18, 8, 23, 26, 20,
                22, 11, 13, 6, 5,
                2, 0, 12, 3, 7
            )
        )

        assertThat(rows(board.numbers.toList()).toList()).isEqualTo(
            listOf(
                listOf(14, 21, 17, 24, 4),
                listOf(10, 16, 15, 9, 19),
                listOf(18, 8, 23, 26, 20),
                listOf(22, 11, 13, 6, 5),
                listOf(2, 0, 12, 3, 7)
            )
        )
    }

    @Test
    fun `call numbers and mark squares on a bingo board`() {
        val board = Board(
            intArrayOf(
                14, 21, 17, 24, 4,
                10, 16, 15, 9, 19,
                18, 8, 23, 26, 20,
                22, 11, 13, 6, 5,
                2, 0, 12, 3, 7
            )
        )

        board.call(7, 4, 9, 5, 11)
        assertThat(board.bingo).isFalse
        assertThat(board.score).isEqualTo(0)
        assertThat(board.rows.first()).isEqualTo(
            listOf(Pair(14, false), Pair(21, false), Pair(17, false), Pair(24, false), Pair(4, true))
        )

        board.call(17, 23, 2, 0, 14, 21)
        assertThat(board.bingo).isFalse
        assertThat(board.score).isEqualTo(0)
        assertThat(board.rows.first()).isEqualTo(
            listOf(Pair(14, true), Pair(21, true), Pair(17, true), Pair(24, false), Pair(4, true))
        )

        board.call(24)
        assertThat(board.bingo).isTrue
        assertThat(board.score).isEqualTo(4512)
    }

    @Test
    fun `parse puzzle into into bingo boards`() {
        val input = sequence {
            yield("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1")
            yield("")
            yield("22 13 17 11  0")
            yield("8  2 23  4 24")
            yield("21  9 14 16  7")
            yield("6 10  3 18  5")
            yield("1 12 20 15 19")
            yield("")
            yield("3 15  0  2 22")
            yield("9 18 13 17  5")
            yield("19  8  7 25 23")
            yield("20 11 10 24  4")
            yield("14 21 16 12  6")
            yield("")
            yield("14 21 17 24  4")
            yield("10 16 15  9 19")
            yield("18  8 23 26 20")
            yield("22 11 13  6  5")
            yield("2  0 12  3  7")
            yield("")
        }

        val (calls, boards) = parse(input.iterator())
        assertThat(calls.size).isEqualTo(27)
        assertThat(boards.size).isEqualTo(3)
    }
}
