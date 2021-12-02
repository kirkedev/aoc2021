package day1

import lib.getLines

fun main() {
    val depths = getLines("day1").map(String::toInt)
    println(increasing(depths))
}
