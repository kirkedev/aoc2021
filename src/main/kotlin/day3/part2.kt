package day3

fun pack(bits: IntArray): UInt =
    pack(bits.map { it == 1 })

tailrec fun oxygen(codes: Iterable<IntArray>, position: Int = 0): UInt {
    val matches = countBits(codes.asSequence()).let { (count, totals) ->
        if (totals[position] >= count / 2F) 1 else 0
    }.let { value ->
        codes.filter { it[position] == value }
    }

    return if (matches.size == 1) pack(matches[0]) else oxygen(matches, position + 1)
}

tailrec fun scrubber(codes: Iterable<IntArray>, position: Int = 0): UInt {
    val matches = countBits(codes.asSequence()).let { (count, totals) ->
        if (totals[position] >= count / 2F) 0 else 1
    }.let { value ->
        codes.filter { it[position] == value }
    }

    return if (matches.size == 1) pack(matches[0]) else scrubber(matches, position + 1)
}

fun main() {
    val codes = getCodes().toList()
    println(oxygen(codes) * scrubber(codes))
}
