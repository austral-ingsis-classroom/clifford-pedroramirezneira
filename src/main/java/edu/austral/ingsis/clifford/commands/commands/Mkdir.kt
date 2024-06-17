package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.FileSystem

class Mkdir(private val name: String) : ICommand {
    override fun execute(): String {
        FileSystem.addNode(Directory(name))
        return "'$name' directory created"
    }
}
