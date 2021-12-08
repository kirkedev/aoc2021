import day8.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day8Test {
    @Test
    fun `test parsing a segment`() {
        val (input, output) = parse("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf")
        assertThat(input.size).isEqualTo(10)
        assertThat(output.size).isEqualTo(4)
    }
}
