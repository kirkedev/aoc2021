package day3

import lib.getLines

fun parse(input: String): IntArray =
    input.map(Character::getNumericValue).toIntArray()

fun getCodes(): Sequence<IntArray> =
    getLines("day3").map(::parse)

fun countBits(input: Sequence<IntArray>): Pair<Int, IntArray> {
    val codes = input.iterator()
    val first = Pair(1, codes.next())

    return codes.asSequence().fold(first) { (count, totals), code ->
        Pair(count + 1, totals.zip(code, Int::plus).toIntArray())
    }
}
