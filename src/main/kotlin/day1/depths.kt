package day1

fun increasing(depths: Sequence<Int>): Int =
    depths.zipWithNext().count { (last, current) -> current > last }

fun windowedSum(depths: Sequence<Int>, size: Int): Sequence<Int> =
    depths.windowed(size).map(List<Int>::sum)
