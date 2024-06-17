package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.FileSystem

class Rm(private val name: String) : ICommand {
    override fun execute(): String {
        val cannotRemove = "cannot remove '$name'"
        val node = CLI.directory?.getNode(name) ?: FileSystem.getNode(name)
        return when (node) {
            null -> cannotRemove
            is Directory -> cannotRemove
            else -> {
                val currentNodes = CLI.directory?.getNodes()?.size ?: FileSystem.getNodes().size
                CLI.directory?.removeNode(name) ?: FileSystem.removeNode(name)
                val nodes = CLI.directory?.getNodes()?.size ?: FileSystem.getNodes().size
                return when {
                    currentNodes == nodes -> cannotRemove
                    else -> "'$name' removed"
                }
            }
        }
    }
}
