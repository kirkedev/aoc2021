package day6

import lib.getLines
import java.util.LinkedList

fun parse(input: String): LongArray =
    input.split(',')
        .map(String::toInt)
        .fold(LongArray(9)) { totals, timer ->
            totals[timer] += 1L
            totals
        }

fun getFish(): LongArray =
    getLines("day6").first().run(::parse)

fun population(start: LongArray): Sequence<Long> = sequence {
    val state = LinkedList(start.toList())

    while (true) {
        yield(state.sum())

        val spawned = state.remove()
        state.add(spawned)
        state[6] += spawned
    }
}
