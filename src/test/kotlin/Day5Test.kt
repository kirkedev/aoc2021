import day5.Line
import day5.Plot
import day5.Point
import day5.parseLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun `parse input into lines`() {
        val input = sequenceOf(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2"
        )

        assertThat(parseLines(input).toList()).isEqualTo(
            listOf(
                Line(Point(0, 9), Point(5, 9)),
                Line(Point(8, 0), Point(0, 8)),
                Line(Point(9, 4), Point(3, 4)),
                Line(Point(2, 2), Point(2, 1)),
                Line(Point(7, 0), Point(7, 4)),
                Line(Point(6, 4), Point(2, 0)),
                Line(Point(0, 9), Point(2, 9)),
                Line(Point(3, 4), Point(1, 4)),
                Line(Point(0, 0), Point(8, 8)),
                Line(Point(5, 5), Point(8, 2))
            )
        )
    }

    @Test
    fun `test vertical line`() {
        val line = Line(Point(2, 2), Point(2, 1))
        assertThat(line.isHorizontal).isFalse
        assertThat(line.isVertical).isTrue
        assertThat(line.isStraight).isTrue
        assertThat(line.points.toList()).isEqualTo(
            listOf(
                Point(2, 2),
                Point(2, 1)
            )
        )
    }

    @Test
    fun `test horizontal line`() {
        val line = Line(Point(0, 9), Point(5, 9))
        assertThat(line.isHorizontal).isTrue
        assertThat(line.isVertical).isFalse
        assertThat(line.isStraight).isTrue
        assertThat(line.points.toList()).isEqualTo(
            listOf(
                Point(0, 9),
                Point(1, 9),
                Point(2, 9),
                Point(3, 9),
                Point(4, 9),
                Point(5, 9)
            )
        )
    }

    @Test
    fun `draw a straight line`() {
        val line = Line(Point(0, 9), Point(5, 9))
        val plot = Plot(10, 10).draw(line)

        assertThat(plot.points.count { it > 0 }).isEqualTo(6)
        assertThat(line.points.map(plot::get).all { it == 1 }).isTrue
    }

    @Test
    fun `draw a diagonal line`() {
        val plot = Plot(10, 10).draw(Line(Point(1, 1), Point(3, 3)))
        assertThat(plot.points.count { it > 0 }).isEqualTo(3)
        assertThat(sequenceOf(Point(1, 1), Point(2, 2), Point(3, 3)).map(plot::get).all { it == 1 }).isTrue
    }

    @Test
    fun `draw overlapping straight lines`() {
        val plot = sequenceOf(
            Line(Point(0, 9), Point(5, 9)),
            Line(Point(8, 0), Point(0, 8)),
            Line(Point(9, 4), Point(3, 4)),
            Line(Point(2, 2), Point(2, 1)),
            Line(Point(7, 0), Point(7, 4)),
            Line(Point(6, 4), Point(2, 0)),
            Line(Point(0, 9), Point(2, 9)),
            Line(Point(3, 4), Point(1, 4)),
            Line(Point(0, 0), Point(8, 8)),
            Line(Point(5, 5), Point(8, 2))
        ).filter(Line::isStraight).fold(Plot(10, 10)) { plot, line ->
            plot.draw(line)
        }

        assertThat(plot.points.count { point -> point > 1 }).isEqualTo(5)
    }

    @Test
    fun `draw overlapping lines`() {
        val plot = sequenceOf(
            Line(Point(0, 9), Point(5, 9)),
            Line(Point(8, 0), Point(0, 8)),
            Line(Point(9, 4), Point(3, 4)),
            Line(Point(2, 2), Point(2, 1)),
            Line(Point(7, 0), Point(7, 4)),
            Line(Point(6, 4), Point(2, 0)),
            Line(Point(0, 9), Point(2, 9)),
            Line(Point(3, 4), Point(1, 4)),
            Line(Point(0, 0), Point(8, 8)),
            Line(Point(5, 5), Point(8, 2))
        ).fold(Plot(10, 10)) { plot, line ->
            plot.draw(line)
        }

        assertThat(plot.points.count { point -> point > 1 }).isEqualTo(12)
    }
}
