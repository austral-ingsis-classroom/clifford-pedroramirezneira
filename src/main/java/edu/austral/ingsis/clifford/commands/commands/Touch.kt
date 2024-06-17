package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.File
import edu.austral.ingsis.clifford.fs.FileSystem

class Touch(private val name: String) : ICommand {
    override fun execute(): String {
        val node = CLI.directory?.getNode(name) ?: FileSystem.getNode(name)
        if (node != null) return replace()
        when {
            CLI.directory == null -> FileSystem.addNode(File(name))
            else -> CLI.directory!!.addNode(File(name))
        }
        return "'$name' file created"
    }

    private fun replace(): String {
        CLI.directory?.removeNode(name) ?: FileSystem.removeNode(name)
        CLI.directory?.addNode(File(name)) ?: FileSystem.addNode(File(name))
        return "'$name' file created"
    }
}
