package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.FileSystem

class Ls(private val ord: String? = null) : ICommand {
    override fun execute(): String {
        val nodes = (CLI.directory?.getNodes() ?: FileSystem.getNodes()).map { it.name }
        return when (ord) {
            null -> nodes.joinToString(" ")
            "asc" -> nodes.sorted().joinToString(" ")
            "desc" -> nodes.sortedDescending().joinToString(" ")
            else -> ""
        }
    }
}
