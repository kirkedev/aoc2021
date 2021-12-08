package day8

typealias Signal = String

typealias Segment = Pair<List<Signal>, List<Signal>>

fun parse(line: String) =
    line.split('|').map(String::trim).map { it.split(' ') }
