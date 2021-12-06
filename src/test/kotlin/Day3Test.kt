import day3.countBits
import day3.oxygen
import day3.pack
import day3.parse
import day3.scrubber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `aggregate set bits and count lines`() {
        val (count, totals) = countBits(
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

    @Test
    fun `pack an IntArray into a bitmask`() {
        assertThat(pack(intArrayOf(1, 0, 1, 1, 0))).isEqualTo(0b10110U)
    }

    @Test
    fun `calculate oxygen generator rating`() {
        val codes = sequenceOf(
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

        assertThat(oxygen(codes.toList())).isEqualTo(0b10111U)
    }

    @Test
    fun `calculate scrubber rating`() {
        val codes = sequenceOf(
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

        assertThat(scrubber(codes.toList())).isEqualTo(0b01010U)
    }
}
