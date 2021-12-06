package day3

fun pack(booleans: Iterable<Boolean>): UInt =
    booleans.fold(0U) { bits, value ->
        (bits shl 1) + if (value) 1U else 0U
    }

fun main() {
    val modes = countBits(getCodes()).let { (count, totals) -> totals.map { it > count / 2 } }
    println(pack(modes) * pack(modes.map(Boolean::not)))
}
