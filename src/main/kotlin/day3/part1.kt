package day3

fun pack(booleans: Iterable<Boolean>): UInt =
    booleans.fold(0U) { bits, value ->
        (bits shl 1) + if (value) 1U else 0U
    }

fun main() {
    val modes = countBits(getCodes()).let { (count, totals) ->
        totals.map { if (it > count / 2) 1 else 0 }
    }

    val gamma = pack(modes.map { it == 1 })
    val epsilon = pack(modes.map { it == 0 })

    println(gamma * epsilon)
}
