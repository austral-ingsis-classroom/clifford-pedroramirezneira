package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.ICommand
import edu.austral.ingsis.clifford.commands.commands.Ls
import edu.austral.ingsis.clifford.commands.commands.NullCommand

class LsBuilder(private val params: List<String> = listOf()) : ICommandBuilder {

    override fun add(param: String): ICommandBuilder {
        return LsBuilder(params + param)
    }

    override fun build(): ICommand {
        return when (params.size) {
            0 -> return Ls()
            1 -> return Ls(params[0].split("=")[1])
            else -> NullCommand()
        }
    }
}
