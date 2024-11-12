package ast;

/**
 * Representa un nodo en el árbol de sintaxis abstracta para una instrucción `continue`.
 */
public class ContinueNode extends StatementNode {

    /**
     * Genera la representación en formato DOT de un nodo `continue`.
     * 
     * @return Representación en formato DOT del nodo `continue`.
     */
    @Override
    public String toDot() {
        return "ContinueNode [label=\"continue\"];\n";
    }

    /**
     * Representación en formato de cadena de un nodo ContinueNode.
     * 
     * @return Cadena representando el nodo `continue`.
     */
    @Override
    public String toString() {
        return "ContinueNode { continue }";
    }
}
