package edu.austral.ingsis

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.FileSystem

class FSRunner : FileSystemRunner {
    override fun executeCommands(commands: MutableList<String>?): MutableList<String> {
        CLI.directory = null
        CLI.name = null
        FileSystem.removeNodes()
        return commands!!.map { args ->
            CLI.execute(args)
        }.toMutableList()
    }
}
