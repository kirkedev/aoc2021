package day6

import lib.getLines
import java.util.LinkedList

fun parse(input: String): LongArray =
    input.split(',')
        .map(String::toInt)
        .fold(LongArray(9)) { totals, timer ->
            totals.apply { set(timer, get(timer) + 1L) }
        }

fun getFish(): LongArray =
    getLines("day6").first().run(::parse)

fun population(start: LongArray): Sequence<Long> =
    generateSequence(LinkedList(start.toList())) { states ->
        states.remove().let { spawned ->
            states.apply {
                add(spawned)
                set(6, get(6) + spawned)
            }
        }
    }.map(List<Long>::sum)
