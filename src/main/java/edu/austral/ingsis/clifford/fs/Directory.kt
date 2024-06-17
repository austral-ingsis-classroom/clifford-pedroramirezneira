package edu.austral.ingsis.clifford.fs

class Directory(override val name: String) : INode {
    private val nodes: MutableList<INode> = mutableListOf()

    fun addNode(node: INode) {
        nodes.add(node)
    }

    fun getNode(name: String): INode? {
        return nodes.find { it.name == name }
    }

    fun removeNode(name: String): Boolean {
        return nodes.removeIf { it.name == name }
    }
}
