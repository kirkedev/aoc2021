package lib

import java.io.File

fun getInput(day: String): File =
    File(ClassLoader.getSystemResource("$day/input").file)

fun getLines(day: String): List<String> =
    getInput(day).readLines()
