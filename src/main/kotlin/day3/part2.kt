package day3

fun pack(bits: IntArray): UInt =
    pack(bits.map { it == 1 })

fun oxygen(codes: List<IntArray>, position: Int = 0): UInt {
    val value = countBits(codes.asSequence()).let { (count, totals) ->
        if (totals[position] >= count / 2F) 1 else 0
    }

    val matches = codes.filter { it[position] == value }

    return if (matches.size == 1) pack(matches[0]) else oxygen(matches, position + 1)
}

fun scrubber(codes: List<IntArray>, position: Int = 0): UInt {
    val value = countBits(codes.asSequence()).let { (count, totals) ->
        if (totals[position] < count / 2F) 1 else 0
    }

    val matches = codes.filter { it[position] == value }

    return if (matches.size == 1) pack(matches[0]) else scrubber(matches, position + 1)
}

fun main() {
    val codes = getCodes().toList()
    println(oxygen(codes) * scrubber(codes))
}
