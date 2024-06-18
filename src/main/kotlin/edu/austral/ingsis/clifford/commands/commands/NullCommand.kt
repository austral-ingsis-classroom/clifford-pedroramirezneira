package edu.austral.ingsis.clifford.commands.commands

class NullCommand : ICommand {
    override fun execute(): String {
        return ""
    }
}
