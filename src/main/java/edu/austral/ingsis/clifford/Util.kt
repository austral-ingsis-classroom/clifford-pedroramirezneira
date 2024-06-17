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
}
