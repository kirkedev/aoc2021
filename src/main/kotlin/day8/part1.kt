package day8

import lib.getLines

fun main() {
    getLines("day8").map(::parse).sumOf { (_, output) ->
        output.count {
            it.length == 2 || it.length == 3 || it.length == 4 || it.length == 7
        }
    }.run(::println)
}
