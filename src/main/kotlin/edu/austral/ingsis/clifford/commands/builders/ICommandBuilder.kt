package edu.austral.ingsis.clifford.commands.builders

import edu.austral.ingsis.clifford.commands.commands.ICommand

interface ICommandBuilder {
    fun add(param: String): ICommandBuilder
    fun build(): ICommand
}
