package edu.austral.ingsis

import edu.austral.ingsis.clifford.cli.CLI

class FSRunner : FileSystemRunner {
    private val cli = CLI()

    override fun executeCommands(commands: MutableList<String>?): MutableList<String> {
        return commands!!.map { args ->
            cli.execute(args)
        }.toMutableList()
    }
}
