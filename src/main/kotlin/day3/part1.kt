package day3

fun pack(booleans: Iterable<Boolean>): UInt =
    booleans.fold(0U) { bits, value ->
        (bits shl 1) + if (value) 1U else 0U
    }

fun main() {
    val (count, totals) = getTotals(getCodes())
    val gamma = pack(totals.map { it > count / 2 })
    val epsilon = pack(totals.map { it < count / 2 })
    println(gamma * epsilon)
}
