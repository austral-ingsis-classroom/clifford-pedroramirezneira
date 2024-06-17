package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.ICommand
import edu.austral.ingsis.clifford.commands.commands.NullCommand
import edu.austral.ingsis.clifford.commands.commands.Touch

class TouchBuilder(private val params: List<String> = listOf()) : ICommandBuilder {
    override fun add(param: String): ICommandBuilder {
        return TouchBuilder(params + param)
    }

    override fun build(): ICommand {
        return when (params.size) {
            1 -> Touch(params[0])
            else -> NullCommand()
        }
    }
}
