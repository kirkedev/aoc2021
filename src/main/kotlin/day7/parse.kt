package day7

import lib.getLines
import kotlin.math.abs

fun parse(input: String): List<Int> =
    input.split(',').map(String::toInt)

fun getCrabs(): List<Int> =
    getLines("day7").first().run(::parse)

fun move(positions: List<Int>, to: Int): Int =
    positions.sumOf { position -> abs(position - to) }
