package edu.austral.ingsis.clifford.fs

object FileSystem : IFileSystem {
    private val nodes: MutableList<INode> = mutableListOf()

    override fun addNode(node: INode) {
        nodes.add(node)
    }

    override fun getNode(name: String): INode? {
        return nodes.find { it.name == name }
    }

    override fun getNodes(): List<INode> {
        return nodes
    }

    override fun removeNode(name: String) {
        nodes.removeIf { it.name == name }
    }

    override fun removeNodes() {
        nodes.clear()
    }
}
