package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.Util
import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.FileSystem
import edu.austral.ingsis.clifford.fs.Root

private const val NOT_FOUND = "Not found"

class Cd(private val path: String) : ICommand {
    override fun execute(): String {
        return when {
            path == ".." -> {
                when (CLI.directory) {
                    null -> return "Moved to directory '/'"
                    else -> {
                        val parent = Util.findParent(CLI.directory!!)
                        return when {
                            parent is Root -> {
                                CLI.directory = null
                                CLI.name = null
                                "Moved to directory '/'"
                            }

                            else -> {
                                CLI.directory = parent
                                CLI.name = parent!!.name
                                "Moved to directory '${parent.name}'"
                            }

                        }

                    }
                }
            }

            path == "." -> "Moved to directory '${CLI.name}'"

            path.startsWith("/") -> {
                val subPaths = path.split("/")
                for (subPath in subPaths) {
                    return when (val subDirectory = FileSystem.getNode(subPath)) {
                        null -> NOT_FOUND
                        !is Directory -> NOT_FOUND
                        else -> {
                            CLI.directory = subDirectory
                            CLI.name = subDirectory.name
                            "Moved to directory '${subDirectory.name}'"
                        }
                    }
                }
                NOT_FOUND
            }

            else -> when (CLI.directory) {
                null -> {
                    return when (val child = FileSystem.getNode(path)) {
                        null -> NOT_FOUND
                        !is Directory -> NOT_FOUND
                        else -> {
                            println(child.name)
                            CLI.directory = child
                            CLI.name = "/${child.name}"
                            "Moved to directory '${child.name}'"
                        }
                    }
                }

                else -> {
                    return when (val child = CLI.directory!!.getNode(path)) {
                        null -> NOT_FOUND
                        !is Directory -> NOT_FOUND
                        else -> {
                            CLI.directory = child
                            CLI.name = child.name
                            "Moved to directory '${child.name}'"
                        }
                    }
                }
            }
        }
    }
}
