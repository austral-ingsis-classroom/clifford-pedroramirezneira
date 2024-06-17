package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.ICommand
import edu.austral.ingsis.clifford.commands.commands.Pwd

class PwdBuilder : ICommandBuilder {
    override fun add(param: String): ICommandBuilder {
        return this
    }

    override fun build(): ICommand {
        return Pwd()
    }
}
