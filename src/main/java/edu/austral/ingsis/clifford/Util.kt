package edu.austral.ingsis.clifford

import edu.austral.ingsis.clifford.cli.CLI
import edu.austral.ingsis.clifford.fs.Directory
import edu.austral.ingsis.clifford.fs.FileSystem
import edu.austral.ingsis.clifford.fs.INode
import edu.austral.ingsis.clifford.fs.Root

object Util {
    fun findParent(node: INode): Directory? {
        if (FileSystem.getNodes().contains(node)) return Root()
        for (child in FileSystem.getNodes()) {
            if (child is Directory) {
                val parent = findParent(node, child)
                if (parent != null) return parent
            }
        }
        return null
    }

    private fun findParent(node: INode, currentDirectory: Directory): Directory? {
        if (currentDirectory.getNodes().contains(node)) return currentDirectory
        for (child in currentDirectory.getNodes()) {
            if (child is Directory) {
                val parent = findParent(node, child)
                if (parent != null) return parent
            }
        }
        return null
    }

    fun findNode(path: List<String>, startFromRoot: Boolean = false): Pair<Directory, String>? {
        val children = when {
            startFromRoot -> FileSystem.getNodes()
            else -> CLI.directory?.getNodes() ?: FileSystem.getNodes()
        }
        for (child in children) {
            if (child is Directory && child.name == path[0]) {
                if (path.size == 1) return child to child.name
                return findNode(path.subList(1, path.size), child, child.name)
            }
        }
        return null
    }

    private fun findNode(
        path: List<String>,
        currentDirectory: Directory,
        fullPath: String
    ): Pair<Directory, String>? {
        if (path.isEmpty()) return currentDirectory to fullPath
        for (child in currentDirectory.getNodes()) {
            if (child is Directory && child.name == path[0]) {
                if (path.size == 1) return child to "$fullPath/${child.name}"
                return findNode(
                    path.subList(1, path.size),
                    child,
                    "$fullPath/${child.name}"
                )
            }
        }
        return null
    }
}
