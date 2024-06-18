package edu.austral.ingsis.clifford.fs

interface IFileSystem {
    fun addNode(node: INode)
    fun getNode(name: String): INode?
    fun getNodes(): List<INode>
    fun removeNode(name: String)
    fun removeNodes()
}
