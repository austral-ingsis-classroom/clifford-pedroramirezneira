package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.File
import edu.austral.ingsis.clifford.fs.FileSystem

class Touch(private val name: String) : ICommand {
    override fun execute(): String {
        when (CLI.directory) {
            null -> FileSystem.addNode(File(name))
            else -> CLI.directory!!.addNode(File(name))
        }
        return "'$name' file created"
    }
}
