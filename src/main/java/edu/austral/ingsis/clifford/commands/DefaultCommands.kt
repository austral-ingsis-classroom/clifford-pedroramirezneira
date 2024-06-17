package edu.austral.ingsis.clifford.commands

import edu.austral.ingsis.clifford.commands.builders.ICommandBuilder
import edu.austral.ingsis.clifford.commands.builders.LsBuilder
import edu.austral.ingsis.clifford.commands.builders.MkdirBuilder

val defaultCommands: Map<String, ICommandBuilder> = mapOf(
    "ls" to LsBuilder(),
    "mkdir" to MkdirBuilder()
)
