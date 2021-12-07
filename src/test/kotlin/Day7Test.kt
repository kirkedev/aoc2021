import day7.aggregateMoves
import day7.move
import day7.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day7Test {
    @Test
    fun `parse crab positions to a list`() {
        assertThat(parse("16,1,2,0,4,2,7,1,2,14")).isEqualTo(listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14))
    }

    @Test
    fun `calculate fuel of move to a position`() {
        val positions = listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
        assertThat(move(positions, 2)).isEqualTo(37)
        assertThat(move(positions, 1)).isEqualTo(41)
        assertThat(move(positions, 3)).isEqualTo(39)
        assertThat(move(positions, 10)).isEqualTo(71)
    }

    @Test
    fun `calculate fuel of aggregated moves to a position`() {
        val positions = listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
        assertThat(aggregateMoves(positions, 5)).isEqualTo(168)
        assertThat(aggregateMoves(positions, 2)).isEqualTo(206)
    }
}
