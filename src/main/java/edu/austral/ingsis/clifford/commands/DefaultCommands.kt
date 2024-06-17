package edu.austral.ingsis.clifford.commands

import edu.austral.ingsis.clifford.commands.builders.CdBuilder
import edu.austral.ingsis.clifford.commands.builders.ICommandBuilder
import edu.austral.ingsis.clifford.commands.builders.LsBuilder
import edu.austral.ingsis.clifford.commands.builders.MkdirBuilder
import edu.austral.ingsis.clifford.commands.builders.PwdBuilder
import edu.austral.ingsis.clifford.commands.builders.TouchBuilder

val defaultCommands: Map<String, ICommandBuilder> = mapOf(
    "ls" to LsBuilder(),
    "mkdir" to MkdirBuilder(),
    "touch" to TouchBuilder(),
    "cd" to CdBuilder(),
    "pwd" to PwdBuilder()
)
