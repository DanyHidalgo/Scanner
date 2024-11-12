package ast;

/**
 * Representa un nodo en el árbol de sintaxis abstracta para una instrucción `break`.
 */
public class BreakNode extends StatementNode {
    
    /**
     * Genera la representación en formato DOT de un nodo `break`.
     * 
     * @return Representación en formato DOT del nodo `break`.
     */
    @Override
    public String toDot() {
        return "BreakNode [label=\"break\"];\n";
    }

    /**
     * Representación en formato de cadena de un nodo BreakNode.
     * 
     * @return Cadena representando el nodo `break`.
     */
    @Override
    public String toString() {
        return "BreakNode { break }";
    }
}
