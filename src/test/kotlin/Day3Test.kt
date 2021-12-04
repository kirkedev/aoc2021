import day3.getTotals
import day3.pack
import day3.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `aggregate set bits and count lines`() {
        val (count, totals) = getTotals(
            sequenceOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
            ).map(::parse)
        )

        assertThat(count).isEqualTo(12)
        assertThat(totals).isEqualTo(intArrayOf(7, 5, 8, 7, 5))
    }

    @Test
    fun `pack a sequence of booleans into a bitmask`() {
        assertThat(pack(intArrayOf(7, 5, 8, 7, 5).map { it > 6 })).isEqualTo(0b10110U)
    }
}
