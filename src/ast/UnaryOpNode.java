package ast;

/**
 * Representa un nodo para una operación unaria en el árbol de sintaxis abstracta.
 * Un nodo UnaryOpNode contiene una expresión y un operador unario (e.g., "-", "NOT").
 */
public class UnaryOpNode extends ExprNode {
    private ExprNode expr;  // Expresión asociada a la operación unaria
    private String op;      // El operador unario (e.g., "-", "NOT")

    /**
     * Constructor para crear un nodo UnaryOpNode.
     * 
     * @param expr Expresión que se somete a la operación unaria.
     * @param op   El operador unario (e.g., "-", "NOT").
     */
    public UnaryOpNode(ExprNode expr, String op) {
        this.expr = expr;
        this.op = op;
    }

    /**
     * Genera la representación en formato DOT de un nodo UnaryOpNode.
     * 
     * @return Representación en formato DOT del nodo UnaryOpNode.
     */
    @Override
    public String toDot() {
        // Asegurarse de que expr no sea nulo antes de invocar toDot() recursivamente
        String exprDot = (expr != null) ? expr.toDot() : "";
        
        // Representar el nodo en formato DOT
        return "UnaryOpNode [label=\"" + op + "\"];\n" + exprDot;
    }

    /**
     * Representación en formato de cadena de un nodo UnaryOpNode.
     * 
     * @return La cadena representando la operación unaria.
     */
    @Override
    public String toString() {
        // Agregar paréntesis alrededor de la expresión para mayor claridad
        return "UnaryOpNode { " + op + " (" + expr.toString() + ") }";
    }

    // Getters
    public ExprNode getExpr() {
        return expr;
    }

    public String getOp() {
        return op;
    }
}
