package day7

import lib.getLines

fun parse(input: String): List<Int> =
    input.split(',').map(String::toInt)

fun getCrabs(): List<Int> =
    getLines("day7").first().run(::parse)
