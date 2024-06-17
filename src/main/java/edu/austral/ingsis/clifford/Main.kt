package edu.austral.ingsis.clifford

import edu.austral.ingsis.clifford.commands.builders.LsBuilder
import edu.austral.ingsis.clifford.fs.FileSystem

fun main() {
    val si = FileSystem
    val hola = LsBuilder()
        .add("si")
        .add("Si")
        .build()
    hola.execute()
}
