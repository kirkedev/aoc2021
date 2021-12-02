import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import day1.increasing
import day1.windowedSum

class Day1Test {
    @Test
    fun testIncreases() {
        val depths = sequenceOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        assertThat(increasing(depths)).isEqualTo(7)
    }

    @Test
    fun testMovingSum() {
        val depths = sequenceOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val sums = windowedSum(depths, 3)
        assertThat(sums.toList()).isEqualTo(listOf(607, 618, 618, 617, 647, 716, 769, 792))
        assertThat(increasing(sums)).isEqualTo(5)
    }
}
