package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.FileSystem

class Rm(private val name: String, private val recursive: Boolean = false) : ICommand {
    private val cannotRemove = "cannot remove '$name'"

    override fun execute(): String {
        return when (recursive) {
            true -> recursive()
            else -> standard()
        }
    }

    private fun standard(): String {
        val node = CLI.directory?.getNode(name) ?: FileSystem.getNode(name)
        return when (node) {
            null -> cannotRemove
            is Directory -> "$cannotRemove, is a directory"
            else -> {
                CLI.directory?.removeNode(name) ?: FileSystem.removeNode(name)
                "'$name' removed"

            }
        }
    }

    private fun recursive(): String {
        val node = CLI.directory?.getNode(name) ?: FileSystem.getNode(name)
        return when (node) {
            null -> cannotRemove
            !is Directory -> "$cannotRemove, is not a directory"
            else -> {
                CLI.directory?.removeNode(name) ?: FileSystem.removeNode(name)
                "'$name' removed"
            }
        }
    }
}
