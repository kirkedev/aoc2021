import day6.parse
import day6.population
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun `parse initial state`() {
        assertThat(parse("3,4,3,1,2")).isEqualTo(longArrayOf(0, 1, 1, 2, 1, 0, 0, 0, 0))
    }

    @Test
    fun `simulate lanternfish spawning`() {
        val fish = population(parse("3,4,3,1,2")).iterator()
        assertThat(fish.next()).isEqualTo(5)
        assertThat(fish.next()).isEqualTo(5)
        assertThat(fish.next()).isEqualTo(6)
        assertThat(fish.next()).isEqualTo(7)

        assertThat(population(parse("3,4,3,1,2")).elementAt(18)).isEqualTo(26)
        assertThat(population(parse("3,4,3,1,2")).elementAt(80)).isEqualTo(5934)
        assertThat(population(parse("3,4,3,1,2")).elementAt(256)).isEqualTo(26_984_457_539)
    }
}
