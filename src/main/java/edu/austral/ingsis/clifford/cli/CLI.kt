package edu.austral.ingsis.clifford.cli

import edu.austral.ingsis.clifford.commands.defaultCommands

class CLI : ICLI {
    private val commands = defaultCommands

    override fun execute(input: String): String {
        val args = input.split(" ")
        var builder = commands[args[0]] ?: return ""
        val params = args.subList(1, args.size)
        for (param in params) {
            builder = builder.add(param)
        }
        return builder.build().execute()
    }
}
