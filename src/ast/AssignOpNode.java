package ast;

/**
 * Representa un nodo para un operador de asignación en el árbol de sintaxis abstracta.
 * Los operadores de asignación pueden ser '=', '+=', '-=' etc.
 */
public class AssignOpNode extends ASTNode {
    private String operator;  // El operador de asignación (por ejemplo '=', '+=', etc.)
    private final String nodeId;  // ID único para cada nodo

    private static int counter = 0;  // Contador estático para generar IDs únicos

    /**
     * Constructor para crear un nodo AssignOpNode.
     * Asigna un ID único a cada instancia utilizando el contador estático.
     * 
     * @param operator El operador de asignación (por ejemplo '=', '+=', etc.)
     */
    public AssignOpNode(String operator) {
        this.operator = operator;
        this.nodeId = "AssignOpNode" + counter++;  // Generar un ID único para este nodo
    }

    /**
     * Genera la representación en formato DOT del nodo AssignOpNode.
     * 
     * @return Representación en formato DOT del nodo AssignOpNode.
     */
    @Override
    public String toDot() {
        // Generar la representación DOT del nodo con el ID único
        return nodeId + " [label=\"" + operator + "\"];\n";
    }

    // Getter para el operador
    public String getOperator() {
        return operator;
    }

    /**
     * Representación en formato de cadena de un nodo AssignOpNode.
     * 
     * @return El ID único para las relaciones DOT.
     */
    @Override
    public String toString() {
        return nodeId;  // Devolver el ID único para las relaciones
    }
}
