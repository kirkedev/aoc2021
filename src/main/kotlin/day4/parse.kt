package day4

fun parse(input: Iterator<String>): Pair<IntArray, List<Board>> {
    val moves = input.next().split(",").map(String::toInt).toIntArray()

    val boards = Regex("\\s+").let { delimiter ->
        input.asSequence().filterNot(String::isEmpty).chunked(5).map { lines ->
            Board(lines.flatMap { line -> line.trim().split(delimiter).map(String::toInt) }.toIntArray())
        }.toList()
    }

    return Pair(moves, boards)
}
