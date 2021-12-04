package day3

import lib.getLines

fun parse(input: String): IntArray =
    input.map(Character::getNumericValue).toIntArray()

fun getCodes(): Iterator<IntArray> =
    getLines("day3").map(::parse).iterator()
