import day2.AimedPosition
import day2.Direction
import day2.Position
import day2.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun testParse() {
        assertThat(parse("forward 5")).isEqualTo(Pair(Direction.Forward, 5))
        assertThat(parse("down 5")).isEqualTo(Pair(Direction.Down, 5))
        assertThat(parse("up 3")).isEqualTo(Pair(Direction.Up, 3))
    }

    @Test
    fun testPositionMoves() {
        var position = Position().move(Direction.Forward, 5)
        assertThat(position.horizontal).isEqualTo(5)
        assertThat(position.depth).isEqualTo(0)

        position = position.move(Direction.Down, 5)
        assertThat(position.horizontal).isEqualTo(5)
        assertThat(position.depth).isEqualTo(5)

        position = position.move(Direction.Up, 3)
        assertThat(position.horizontal).isEqualTo(5)
        assertThat(position.depth).isEqualTo(2)
    }

    @Test
    fun testAimedPositionMoves() {
        var position = AimedPosition().move(Direction.Forward, 5)
        assertThat(position.horizontal).isEqualTo(5)
        assertThat(position.depth).isEqualTo(0)
        assertThat(position.aim).isEqualTo(0)

        position = position.move(Direction.Down, 5)
        assertThat(position.horizontal).isEqualTo(5)
        assertThat(position.depth).isEqualTo(0)
        assertThat(position.aim).isEqualTo(5)

        position = position.move(Direction.Forward, 8)
        assertThat(position.horizontal).isEqualTo(13)
        assertThat(position.depth).isEqualTo(40)
        assertThat(position.aim).isEqualTo(5)

        position = position.move(Direction.Up, 3)
        assertThat(position.horizontal).isEqualTo(13)
        assertThat(position.depth).isEqualTo(40)
        assertThat(position.aim).isEqualTo(2)

        position = position.move(Direction.Down, 8)
        assertThat(position.horizontal).isEqualTo(13)
        assertThat(position.depth).isEqualTo(40)
        assertThat(position.aim).isEqualTo(10)

        position = position.move(Direction.Forward, 2)
        assertThat(position.horizontal).isEqualTo(15)
        assertThat(position.depth).isEqualTo(60)
        assertThat(position.aim).isEqualTo(10)
    }
}
