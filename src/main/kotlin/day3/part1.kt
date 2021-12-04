package day3

fun main() {
    val codes = getCodes()

    val (count, totals) = codes.asSequence()
        .fold(Pair(1, codes.next())) { (count, totals), code ->
            Pair(count + 1, totals.zip(code, Int::plus).toIntArray())
        }

    val gamma = totals.fold(0U) { bits, total ->
        (bits shl 1) + if (total > count / 2) 1U else 0U
    }

    val distance = UInt.SIZE_BITS - totals.size
    val epsilon = gamma.inv() shl distance shr distance

    println(gamma * epsilon)
}
