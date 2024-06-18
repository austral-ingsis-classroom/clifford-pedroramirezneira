package edu.austral.ingsis.clifford.fs

class File(override val name: String) : INode {
    private var text: String = ""

    fun write(text: String) {
        this.text = text
    }

    fun read(): String {
        return text
    }
}
