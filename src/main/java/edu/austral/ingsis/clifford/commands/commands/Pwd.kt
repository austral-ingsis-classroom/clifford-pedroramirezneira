package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.cli.CLI

class Pwd : ICommand {
    override fun execute(): String {
        return CLI.name ?: "/"
    }
}
