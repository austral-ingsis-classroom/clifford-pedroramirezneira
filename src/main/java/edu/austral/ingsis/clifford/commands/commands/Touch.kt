package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.File
import edu.austral.ingsis.clifford.fs.FileSystem

class Touch(private val name: String) : ICommand {
    override fun execute(): String {
        val node = CLI.directory?.getNode(name) ?: FileSystem.getNode(name)
        when {
            node != null -> none()
            CLI.directory == null -> FileSystem.addNode(File(name))
            else -> CLI.directory!!.addNode(File(name))
        }
        return "'$name' file created"
    }

    private fun none() {}
}
