package ast;

/**
 * Representa un nodo para una operación binaria en el árbol de sintaxis abstracta.
 * Un nodo BinaryOpNode contiene dos expresiones (izquierda y derecha) y un operador binario.
 */
public class BinaryOpNode extends ExprNode {
    private ExprNode left;  // Expresión izquierda
    private ExprNode right; // Expresión derecha
    private String op;      // El operador binario (e.g., "+", "-", "==")

    /**
     * Constructor para crear un nodo BinaryOpNode.
     * 
     * @param left  Expresión izquierda.
     * @param right Expresión derecha.
     * @param op    El operador binario (e.g., "+", "-", "==").
     */
    public BinaryOpNode(ExprNode left, ExprNode right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    /**
     * Genera la representación en formato DOT de un nodo BinaryOpNode.
     * 
     * @return Representación en formato DOT del nodo BinaryOpNode.
     */
    @Override
    public String toDot() {
        // Asegurarse de que left y right no sean nulos antes de invocar toDot() recursivamente
        String leftDot = (left != null) ? left.toDot() : "";
        String rightDot = (right != null) ? right.toDot() : "";

        // Representar el nodo en formato DOT
        return "BinaryOpNode [label=\"" + op + "\"];\n" +
               leftDot + rightDot;  // Agregar las representaciones DOT de las expresiones hijas
    }

    /**
     * Representación en formato de cadena de un nodo BinaryOpNode.
     * 
     * @return La cadena representando la operación binaria.
     */
    @Override
    public String toString() {
        // Agregar paréntesis alrededor de la operación para mayor claridad
        return "BinaryOpNode { (" + left.toString() + " " + op + " " + right.toString() + ") }";
    }

    // Getters
    public ExprNode getLeft() {
        return left;
    }

    public ExprNode getRight() {
        return right;
    }

    public String getOp() {
        return op;
    }
}
