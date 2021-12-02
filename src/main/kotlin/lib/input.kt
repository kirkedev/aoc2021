package lib

import java.io.File
import kotlin.streams.asSequence

fun getInput(day: String): File =
    File(ClassLoader.getSystemResource("$day/input").file)

fun getLines(day: String): Sequence<String> =
    getInput(day).bufferedReader().lines().asSequence()
