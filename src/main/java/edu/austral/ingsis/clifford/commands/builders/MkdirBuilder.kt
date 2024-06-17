package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.ICommand
import edu.austral.ingsis.clifford.commands.commands.Mkdir
import edu.austral.ingsis.clifford.commands.commands.NullCommand

class MkdirBuilder(private val params: List<String> = listOf()) : ICommandBuilder {
    override fun add(param: String): ICommandBuilder {
        return MkdirBuilder(params + param)
    }

    override fun build(): ICommand {
        if (params.size != 1) return NullCommand()
        return Mkdir(params[0])
    }
}
