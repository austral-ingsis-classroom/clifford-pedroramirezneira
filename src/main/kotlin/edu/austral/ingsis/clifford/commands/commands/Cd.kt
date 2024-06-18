package edu.austral.ingsis.clifford.commands.commands

import edu.austral.ingsis.clifford.Util
import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.FileSystem
import edu.austral.ingsis.clifford.fs.INode
import edu.austral.ingsis.clifford.fs.Root


class Cd(private val path: String) : ICommand {
    private val notFound = "'$path' directory does not exist"

    override fun execute(): String {
        return when {
            path == ".." -> {
                when (CLI.directory) {
                    null -> return "moved to directory '/'"
                    else -> {
                        val parent = Util.findParent(CLI.directory!!)
                        return when {
                            parent is Root -> {
                                CLI.directory = null
                                CLI.name = null
                                "moved to directory '/'"
                            }

                            else -> {
                                CLI.directory = parent
                                CLI.name = parent!!.name
                                "moved to directory '${parent.name}'"
                            }

                        }

                    }
                }
            }

            path == "." -> "moved to directory '${CLI.name}'"

            path.startsWith("/") -> {
                return when {
                    path == "/" -> {
                        CLI.directory = null
                        CLI.name = null
                        "moved to directory '/'"
                    }

                    else -> {
                        val subPaths = path.split("/")
                        val directory = Util.findNode(subPaths, startFromRoot = true)
                        return when (directory) {
                            null -> notFound
                            else -> {
                                CLI.directory = directory.first
                                CLI.name = "/${directory.second}"
                                "moved to directory '${directory.second.split("/").last()}'"
                            }
                        }
                    }
                }
            }

            else -> {
                val subPaths = path.split("/")
                return when (val directory = Util.findNode(subPaths)) {
                    null -> notFound
                    else -> {
                        CLI.directory = directory.first
                        CLI.name = "/${directory.second}"
                        "moved to directory '${directory.second.split("/").last()}'"
                    }
                }
            }
        }
    }
}
