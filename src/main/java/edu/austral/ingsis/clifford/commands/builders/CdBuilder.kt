package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.Cd
import edu.austral.ingsis.clifford.commands.commands.ICommand
import edu.austral.ingsis.clifford.commands.commands.NullCommand

class CdBuilder(private val params: List<String> = listOf()) : ICommandBuilder {
    override fun add(param: String): ICommandBuilder {
        return CdBuilder(params + param)
    }

    override fun build(): ICommand {
        return when (params.size) {
            1 -> Cd(params[0])
            else -> NullCommand()
        }
    }
}
