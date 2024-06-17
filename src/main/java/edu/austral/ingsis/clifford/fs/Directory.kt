package edu.austral.ingsis.clifford.fs

open class Directory(override val name: String) : INode {
    private val nodes: MutableList<INode> = mutableListOf()

    fun addNode(node: INode) {
        nodes.add(node)
    }

    fun getNode(name: String): INode? {
        return nodes.find { it.name == name }
    }

    fun getNodes(): List<INode> {
        return nodes
    }

    fun removeNode(name: String): Boolean {
        return nodes.removeIf { it.name == name }
    }

    fun removeNodes() {
        nodes.clear()
    }
}
