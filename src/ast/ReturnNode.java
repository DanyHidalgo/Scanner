package ast;

/**
 * Representa un nodo en el árbol de sintaxis abstracta para una instrucción `return`.
 */
public class ReturnNode extends StatementNode {
    private ExprNode expr;

    /**
     * Constructor para crear un nodo ReturnNode.
     * 
     * @param expr Expresión a devolver en la sentencia `return`.
     * @throws IllegalArgumentException Si la expresión es nula y se espera una.
     */
    public ReturnNode(ExprNode expr) {
        if (expr == null) {
            throw new IllegalArgumentException("La expresión no puede ser nula");
        }
        this.expr = expr;
    }

    /**
     * Genera la representación en formato DOT de un nodo `return`.
     * 
     * @return Representación en formato DOT del nodo `return`.
     */
    @Override
    public String toDot() {
    StringBuilder sb = new StringBuilder();
    String nodeName = "ReturnNode" + hashCode(); // Generar nombre único para el nodo

    sb.append(nodeName).append(" [label=\"return\"];\n");

    // Si hay una expresión, añadirla al DOT y la relación
    if (expr != null) {
        String exprName = "ExprNode" + expr.hashCode();  // Nombre único para la expresión
        sb.append(expr.toDot());  // Generar el DOT para la expresión
        sb.append(nodeName).append(" -> ").append(exprName).append(" [label=\"expr\"];\n");
    }

    return sb.toString();
}


    /**
     * Representación en formato de cadena de un nodo ReturnNode.
     * 
     * @return Cadena representando el nodo.
     */
    @Override
    public String toString() {
        return "ReturnNode { expr=" + (expr != null ? expr.toString() : "null") + " }";
    }

    // Getter
    public ExprNode getExpr() {
        return expr;
    }
}
