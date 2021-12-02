package day1

fun increasing(depths: Iterable<Int>): Int =
    depths.zipWithNext().count { (last, current) -> current > last }

fun windowedSum(depths: Iterable<Int>, size: Int): List<Int> =
    depths.windowed(size).map(List<Int>::sum)
