package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.File
import edu.austral.ingsis.clifford.fs.FileSystem

class Mkdir(private val name: String) : ICommand {
    override fun execute(): String {
        when (CLI.directory) {
            null -> FileSystem.addNode(Directory(name))
            else -> CLI.directory!!.addNode(Directory(name))
        }
        return "'$name' directory created"
    }
}
