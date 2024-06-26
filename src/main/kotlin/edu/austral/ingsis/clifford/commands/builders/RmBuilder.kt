package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.ICommand
import edu.austral.ingsis.clifford.commands.commands.NullCommand
import edu.austral.ingsis.clifford.commands.commands.Rm

class RmBuilder(private val params: List<String> = listOf()) : ICommandBuilder {
    override fun add(param: String): ICommandBuilder {
        return RmBuilder(params + param)
    }

    override fun build(): ICommand {
        return when (params.size) {
            1 -> Rm(params[0])
            2 -> Rm(params[1], recursive = true)
            else -> NullCommand()
        }
    }
}
